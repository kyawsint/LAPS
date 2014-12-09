package nus.iss.laps.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nus.iss.laps.exceptions.*;
import nus.iss.laps.model.*;
import nus.iss.laps.service.*;

;

@Controller
@RequestMapping(value = "/Hierachy")
public class HierachyController {

	@Autowired
	private HierachyService hierachyService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView ListPage() {
		ModelAndView mav = new ModelAndView("HierarchyList");
		List<Hierachy> List = hierachyService.findAll();
		mav.addObject("list", List);
		return mav;
	}

	@RequestMapping(value = "/edit/{staffid}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Integer staffid) {
		ModelAndView mav = new ModelAndView("HierarchyEdit");
		Hierachy type = hierachyService.findById(staffid);
		mav.addObject("type", type);
		return mav;
	}

	@RequestMapping(value = "/edit/{staffid}", method = RequestMethod.POST)
	public String editStaff(@ModelAttribute @Valid Hierachy hierachy,
			@PathVariable int staffid, Model model) throws StaffNotFound {

		Hierachy hi = hierachyService.update(hierachy);

		String message = "Staff was successfully updated.";
		model.addAttribute("message", message);
		return "Message";
	}

	@RequestMapping(value = "/delete/{staffid}", method = RequestMethod.GET)
	public String deleteStaff(@PathVariable Integer staffid, Model model)
			throws StaffNotFound {

		String name = hierachyService.delete(staffid);
		String message = "The Hierarchy of " + name
				+ " was successfully deleted.";

		model.addAttribute("message", message);
		return "Message";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String toTest(@ModelAttribute Hierachy hi, Model model) {
		hierachyService.create(hi);
		String message = "New student " + hi.getStaff_name()
				+ " was successfully created.";
		model.addAttribute("message", message);
		return "test";

	}

}
