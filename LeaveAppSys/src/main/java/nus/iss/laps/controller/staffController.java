package nus.iss.laps.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import nus.iss.laps.exceptions.StaffNotFound;
import nus.iss.laps.model.Staff;

import nus.iss.laps.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/staff")
public class staffController {
	
	@Autowired
	private StaffService sservice;
	
	@RequestMapping(value={"/", "index/{staffid}"}, method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
				
		
		return "manageStaffPage";
	}	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newStaffPage() {
		ModelAndView mav = new ModelAndView("newStaff", "staff",
				new Staff());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewStaff(@ModelAttribute @Valid Staff staff,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("newStaff");

		ModelAndView mav = new ModelAndView();
		String message = "New staff " + staff.getStaff_name()
				+ " was successfully created.";

		sservice.create(staff);
		mav.setViewName("redirect:/DashBoard");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = {"/list","staffList"}, method = RequestMethod.GET)
	public ModelAndView staffListPage() {
		ModelAndView mav = new ModelAndView("staffList");
		List<Staff> staffList = sservice.findAll();
		mav.addObject("staffList", staffList);
		return mav;
	}	
	@RequestMapping(value = "/edit/{staffid}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable int staffid) {
		ModelAndView mav = new ModelAndView("staffEdit");
		Staff staff = sservice.findById(staffid);
		mav.addObject("staff", staff);
		return mav;
	}

	@RequestMapping(value = "/edit/{staffid}", method = RequestMethod.POST)
	public ModelAndView editStaff(@ModelAttribute @Valid Staff  staff,
			BindingResult result, @PathVariable int staffid,
			final RedirectAttributes redirectAttributes) throws StaffNotFound {

		if (result.hasErrors())
			return new ModelAndView("staffEdit");


		ModelAndView mav = new ModelAndView("DashBoard");
		String message = "Student was successfully updated.";

		sservice.updateAll(staff);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{staffid}", method = RequestMethod.GET)
	public ModelAndView deleteStaff(@PathVariable Integer staffid,
			final RedirectAttributes redirectAttributes) throws StaffNotFound {

		ModelAndView mav = new ModelAndView("DashBoard");

		Staff staff  = sservice.delete(staffid);
		String message = "The student " + staff.getStaff_name()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/List", method = RequestMethod.GET)
	public ModelAndView listStaff() {
		
		ModelAndView mav = new ModelAndView("StaffListMgr");
		

		List<Staff> stafflist=sservice.findAll();
		mav.addObject("staffList", stafflist);

		return mav;
	}
}
