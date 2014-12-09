package nus.iss.laps.controller;

import java.util.List;

import javax.validation.Valid;

import nus.iss.laps.model.Leave_Details;
import nus.iss.laps.service.LeaveHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/LeaveHistory")
public class LeaveHistoryController {

	@Autowired
	LeaveHistoryService leavehistoryServ;

	@RequestMapping(value = "/List/{staffid}", method = RequestMethod.GET)
	public ModelAndView listLeaveHistroy(@PathVariable int staffid) {
		ModelAndView mav = new ModelAndView("LeaveHistory");

		List<Leave_Details> leavelist = leavehistoryServ.findByStaffID(staffid);
		mav.addObject("leavelist", leavelist);
		return mav;
	}

	@RequestMapping(value = "/Detail/{leaveID}", method = RequestMethod.GET)
	public ModelAndView detailLeaveHistory(@PathVariable int leaveID) {
		ModelAndView mav = new ModelAndView("LeaveHistoryDetail");
		Leave_Details leavedetail = leavehistoryServ.findByID(leaveID);
		mav.addObject("leavedetail", leavedetail);
		return mav;
	}

/*	@RequestMapping(value = "/List/{staffid}", method = RequestMethod.POST, params = "Approve")
	public ModelAndView ApproveLeave(@PathVariable int staffid) {
		ModelAndView mav = new ModelAndView("leaveHistory");
		List<Leave_Details> approveLeave = leavehistoryServ
				.findByStaffID(staffid);
		mav.addObject("approveLeave", approveLeave);
		return mav;
	}

	@RequestMapping(value = "/List/{staffid}", method = RequestMethod.POST, params = "Reject")
	public ModelAndView RejectLeave(@PathVariable int staffid) {
		ModelAndView mav = new ModelAndView("leaveHistory");
		List<Leave_Details> rejectLeave = leavehistoryServ
				.findByStaffID(staffid);
		mav.addObject("rejectLeave", rejectLeave);
		return mav;
	}*/

	@RequestMapping(value = "/List/{staffid},{leaveid}", method = RequestMethod.POST)
	public ModelAndView CloseLeave( @ModelAttribute @Valid Leave_Details leavedetail ,@PathVariable int staffid,
			@PathVariable int leaveid,final RedirectAttributes redirectAttributtes,
			@RequestParam(required = false, value = "Approve") String approve,
			@RequestParam(required = false, value = "Reject") String reject,
			@RequestParam(required = false, value = "Close") String close) {
		
		
		
		ModelAndView mav = new ModelAndView("LeaveHistory");
		List<Leave_Details> levaelist = leavehistoryServ
				.findByStaffID(staffid);
		System.out.println("leaveID"+leaveid+"-"+"Staffid"+staffid);
		for (Leave_Details l : levaelist) {
			System.out.println(l.toString());
		}
		Leave_Details ld= leavehistoryServ.findByID(leaveid);
		if (approve!=null) {
			ld.setLeaveStatus(approve+"d");
			System.out.println(ld.getLeaveStatus());
		}
		if(reject!=null) {
			ld.setLeaveStatus("Rejected");
			System.out.println(ld.getLeaveStatus());
		}
		if(close!=null){
			System.out.println(ld.getLeaveStatus());
		}
		leavehistoryServ.update(ld);
		List<Leave_Details> test1= leavehistoryServ.findAll();
		for (Leave_Details t : test1) {
			System.out.println(t.toString());
		}
		levaelist = leavehistoryServ
				.findByStaffID(staffid);
		mav.addObject("leavelist", levaelist);
		return mav;
	}
	
	//gaofan
	
		@RequestMapping(value="/gaofan_method" , method=RequestMethod.GET)
		public ModelAndView findByLeaveTypeID(){
			List<Leave_Details> l =leavehistoryServ.findByLeaveTypeID(1);
			ModelAndView mav = new ModelAndView("gaofan","LeaveList",l);
			return mav;
		}
}
