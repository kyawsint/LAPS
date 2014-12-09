package nus.iss.laps.controller;

import java.util.List;

import javax.validation.Valid;

import nus.iss.laps.exceptions.AdminNotFound;
import nus.iss.laps.model.Admin;
import nus.iss.laps.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {

	@Autowired
	private AdminService adiminService;
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editLeavePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("updateLeave");
		Admin type =adiminService.findById(id);
		mav.addObject("type", type);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute @Valid Admin admin,
			 @PathVariable Long id,
			Model model) throws AdminNotFound {


		Admin ad=adiminService.update(admin);

		String message = "Leave Type was successfully updated.";
		model.addAttribute("message", message);
		return "deleteSuccess";
	}
	
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String create()
	{
		return "createLevae";
		
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable Integer id,
			Model model) throws  AdminNotFound {

		
		 String name = adiminService.delete(id);
		String message = "The Leave Type " + name
				+ " was successfully deleted.";

		model.addAttribute("message",message);
		return "deleteSuccess";
	}
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createLeave
	(@RequestParam("typeid")int typeid,@RequestParam("leaveName") String leaveName,Model model)
	{
		Admin ad=new Admin();
		ad.setTypeid(typeid);
		ad.setLeaveName(leaveName);
		adiminService.create(ad);
		String message = "New Leave Type " + ad.getLeaveName()
				+ " was successfully created.";
		model.addAttribute("message",message);
		return "deleteSuccess";
		
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ListPage(Model model) {
		
		List<Admin> List = adiminService.findAll();
		model.addAttribute("list", List);
		return "leavedetail";
	}


	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String toTest(@ModelAttribute Admin ad,Model model)
	{
		adiminService.create(ad);
		String message = "New student " + ad.getLeaveName()
				+ " was successfully created.";
		model.addAttribute("message",message);
		return "test";
		
	}
	
}
