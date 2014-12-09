package nus.iss.laps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import nus.iss.laps.exceptions.ClaimNotFound;
import nus.iss.laps.model.Claim;
import nus.iss.laps.model.LeaveTypes;
import nus.iss.laps.model.Staff;
import nus.iss.laps.service.ClaimService;
import nus.iss.laps.service.LeaveTypeService;
import nus.iss.laps.service.StaffService;
import nus.iss.laps.web.validator.ClaimValidator;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;








@Controller
@RequestMapping(value = "/claim")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;	

	@Autowired
	private ClaimValidator claimValidator;

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(claimValidator);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET )
	public ModelAndView newClaimPage(HttpServletRequest request) {
		
		String username=request.getSession().getAttribute("username").toString();
		int StaffId=claimService.findStaffId(username);		
		double totalOTH=claimService.findTotalOTHours(StaffId);
		Staff s=staffService.findById(StaffId);
		LeaveTypes leaveComp= leaveTypeService.findComp();
		
		Claim c=new Claim();
		c.setSn(s);
		ModelAndView mav = new ModelAndView("AddClaim", "claim",c);
		mav.addObject("totalOTHours",totalOTH);
		mav.addObject("StaffId", StaffId);
		mav.addObject("leaveName",leaveComp.getLeaveName());
		mav.addObject("leaveTypeid", leaveComp.getTypeid());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewClaim(@ModelAttribute @Valid Claim claim,
			BindingResult result, final RedirectAttributes redirectAttributes) {		
		if (result.hasErrors()){
			System.out.println("HAs error");
			return new ModelAndView("AddClaim");						
		}
		ModelAndView mav = new ModelAndView();
		String message = "New claim for staff id " + claim.getStaffID()
				+ " was successfully created.";

		if(claim.getTotalOTHours()>=4 && claim.getNoOfDays()<=claim.getTotalOTHours()/8){
			claim.setLeaveStatus("Applied");			
			claimService.create(claim);
			mav.setViewName("redirect:/DashBoard");
		}else{
			mav.setViewName("AddClaim");
			mav.addObject("claimCondition", "You are allowed to claim only 1/2 a day for every OT 4 hours");
		}		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/edit/{leaveID}",method=RequestMethod.GET)
	public ModelAndView editClaim(@PathVariable int leaveID){		
		ModelAndView mav=new ModelAndView("EditClaim");
		
		Claim claim=claimService.findById(leaveID);
		double totalOTH=claimService.findTotalOTHours(claim.getStaffID());
		claim.setTotalOTHours(totalOTH);
		mav.addObject("claim",claim);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/edit/{leaveID}", method = RequestMethod.POST)
	public ModelAndView editClaimpost(@ModelAttribute @Valid Claim claim,@PathVariable int leaveID,
			BindingResult result,
			final RedirectAttributes redirectAttributes) throws ClaimNotFound  {
		if (result.hasErrors()){
			return new ModelAndView("EditClaim");
		}

		ModelAndView mav = new ModelAndView("redirect:/DashBoard");
		String message = "Claim was successfully updated.";
		if(claim.getTotalOTHours()>=4 && claim.getNoOfDays()<=claim.getTotalOTHours()/8){
			claim.setLeaveStatus("Updated");
			claimService.update(claim);
		}else{
			mav.addObject("claimCondition", "You are allowed to claim only 1/2 a day for every OT 4 hours");
			mav.setViewName("EditClaim");
			
		}		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/delete/{leaveID}",method=RequestMethod.GET)
	public ModelAndView deleteClaim(@PathVariable int leaveID,
			final RedirectAttributes redirectAttributes) throws ClaimNotFound{		
		ModelAndView mav=new ModelAndView("redirect:/DashBoard");
		Claim claim=claimService.findById(leaveID);
		String message = "Claim was successfully Cancelled.";
		if(claim.getLeaveStatus().equals("Approved")){
			staffService.updateCompOff(claim.getNoOfDays(),claim.getStaffID());
		}
		claim.setLeaveStatus("Cancelled");
		claimService.delete(claim);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listClaims(HttpServletRequest request)  throws ClaimNotFound{		
		ModelAndView mav = new ModelAndView("ClaimsList");	
		HttpSession session=request.getSession();
		int staffID=claimService.findStaffId(session.getAttribute("username").toString());
		List<Claim> claimsList=claimService.findClaimsOfStaff(staffID);
		mav.addObject("claimsList", claimsList);
		


		return mav;
	}
}
