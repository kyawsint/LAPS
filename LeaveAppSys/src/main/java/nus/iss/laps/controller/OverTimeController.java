package nus.iss.laps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;



import nus.iss.laps.exceptions.OverTimeNotFound;
import nus.iss.laps.exceptions.StaffNotFound;
import nus.iss.laps.model.OverTime;
import nus.iss.laps.model.Staff;
import nus.iss.laps.service.OverTimeService;
import nus.iss.laps.service.StaffService;
import nus.iss.laps.web.validator.OverTimeValidator;



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
@RequestMapping(value="/otime")
public class OverTimeController {
	
	@Autowired
	private OverTimeService overTimeService;	
	
	@Autowired
	private StaffService staffService;

	@Autowired
	private OverTimeValidator overTimeValidator;


	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(overTimeValidator);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView showOverTime(HttpServletRequest request){
		HttpSession session=request.getSession();
		int Staffid=staffService.findStaffDetails(session.getAttribute("username").toString());
		ModelAndView mav = new ModelAndView("AddOT", "otime",new OverTime());
		mav.addObject("staffid", Staffid);	
		return mav;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView postOverTime(@ModelAttribute OverTime overtime,BindingResult result,final RedirectAttributes redirectAttributes){
		if (result.hasErrors()){
			return new ModelAndView("redirect:/otime/create.html");
		}
		ModelAndView mav=new ModelAndView();	
		String message="Over time entry has been created";
		mav.setViewName("redirect:/DashBoard");		
		overTimeService.create(overtime);
		Staff staffot=staffService.findById(overtime.getStaffid());
		staffot.setTotalOTHours(overtime.getNoOfHours());		
		staffService.update(staffot);
		redirectAttributes.addFlashAttribute("message",message);
		return mav;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView getOTdet(HttpServletRequest request){
		ModelAndView mav=new ModelAndView("OTList");
		HttpSession session=request.getSession();
		int staffID=staffService.findStaffDetails(session.getAttribute("username").toString());
		List<OverTime> listOfOT=overTimeService.ListOfStaffOT(staffID);
		mav.addObject("otlist", listOfOT);
		return mav;
	}
	
	@RequestMapping(value="/edit/{otid}",method=RequestMethod.GET)
	public ModelAndView editOT(@PathVariable int otid){
		
		ModelAndView mav=new ModelAndView("EditOT");
		
		OverTime overtime=overTimeService.findById(otid);
		mav.addObject("otime",overtime);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/edit/{otid}", method = RequestMethod.POST)
	public ModelAndView editOTpost(@ModelAttribute @Valid OverTime overTime,@PathVariable int otid,
			BindingResult result, 
			final RedirectAttributes redirectAttributes) throws OverTimeNotFound,StaffNotFound  {


		if (result.hasErrors()){
			return new ModelAndView("EditOT");
		}

		ModelAndView mav = new ModelAndView("redirect:/DashBoard");
		String message = "Overtime was successfully updated.";	
		OverTime overtime=overTimeService.findById(otid);
	    Staff staffot=staffService.findById(overtime.getStaffid());
	    
	    
	    staffService.updateTotalOT(overtime.getNoOfHours(), overTime.getNoOfHours(),staffot);
	    overTimeService.update(overTime);
	    
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/delete/{otid}",method=RequestMethod.GET)
	public ModelAndView editOTDelete(@PathVariable int otid,final RedirectAttributes redirectAttributes) throws OverTimeNotFound{
		
		ModelAndView mav=new ModelAndView("redirect:/DashBoard");
		String message = "Overtime was successfully deleted.";	
		OverTime overtime=overTimeService.findById(otid);
		overTimeService.delete(overtime);
		Staff staffot=staffService.findById(overtime.getStaffid());
		staffot.setTotalOTHours(-1*overtime.getNoOfHours());		
		staffService.update(staffot);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
