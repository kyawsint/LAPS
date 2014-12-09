package nus.iss.laps.controller;

import java.util.ArrayList;
import java.util.List;

import nus.iss.laps.model.Leave_Details;
import nus.iss.laps.model.staff_details;
import nus.iss.laps.service.leave_detailsService;
import nus.iss.laps.service.staff_detailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping(value="/approveManagement")
public class approveManagement {
 @Autowired
 private leave_detailsService lds;
 @Autowired
 private staff_detailsService sds;
 
 @RequestMapping(value="/approve")
 public ModelAndView approve(){
	 List<Leave_Details> arr1 = lds.findAppendingLeave("Applied");
	 List<Leave_Details> arr2 = lds.findAppendingLeave("Updated");
	 List<Leave_Details> arr = new ArrayList<Leave_Details>();
	 arr.addAll(arr1);
	 arr.addAll(arr2);
	 ModelAndView mav = new ModelAndView("appending","allAppending",arr);
	 return mav;
 }
 @RequestMapping(value="/aorr",method=RequestMethod.POST)
 public String app(String ID ,String apply ){
	 int upID = Integer.parseInt(ID);
     lds.updateStatus(apply, upID);
     if(apply.equals("Approved")){
     Leave_Details ld =lds.findByleaveID(upID);
     staff_details sd =sds.findByStaffid(ld.getStaffID());
     sd.setCompOffConsumed(sd.getCompOffConsumed()+ld.getNoOfDays());
     sds.update(sd);
     }
 	return "DashBoard";
 }

}
