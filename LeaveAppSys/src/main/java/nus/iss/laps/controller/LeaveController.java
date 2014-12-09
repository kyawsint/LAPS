package nus.iss.laps.controller;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nus.iss.laps.model.Claim;
import nus.iss.laps.model.Leave;
import nus.iss.laps.service.LeaveService;
import nus.iss.laps.service.LeaveTypeService;
import nus.iss.laps.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/leave")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value = "/create-leave", method = RequestMethod.GET)
	public ModelAndView newLeavePage(HttpServletRequest request){
		String username=request.getSession().getAttribute("username").toString();
		int staffId=leaveService.findStaffId(username);
		Leave l=new Leave();
		l.setStaffId(staffId);
		l.setLeaveStatus("Applied");
		ModelAndView mav=new ModelAndView("leave-new","leave",l);
		mav.addObject("staffId",staffId);
		mav.addObject("leaveType", leaveTypeService.findAll());
		
		return mav;
	}
	
	@RequestMapping(value = "/create-leave", method = RequestMethod.POST)
	public ModelAndView createNewLeave(@ModelAttribute @Valid Leave leave,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("leave-new");

		ModelAndView mav = new ModelAndView();
		String message = "New Leave was successfully created.";

		leaveService.create(leave);
		mav.setViewName("redirect:/DashBoard");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/leave-list", method = RequestMethod.GET)
	public ModelAndView leaveListPage(HttpServletRequest request) {
		String username=request.getSession().getAttribute("username").toString();
		int staffId=leaveService.findStaffId(username);
		return new ModelAndView("leave-list").addObject("leaveList", leaveService.findByStaffId(staffId));
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editLeavePage(@PathVariable Long id) {
		return new ModelAndView("edit-leave").addObject("editleave", leaveService.findById(id)).addObject("leaveType", leaveTypeService.findAll());
	}
	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public ModelAndView editLeave(@ModelAttribute @Valid Leave leave,
		BindingResult result, @PathVariable Long id,
		final RedirectAttributes redirectAttributes)
		{
			leaveService.update(leave);
			ModelAndView mav = new ModelAndView("redirect:/DashBoard");
			return mav;
		}	
}
