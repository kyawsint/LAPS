package nus.iss.laps.controller;

import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContext;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ="/DashBoard", method = RequestMethod.GET)
	public String displayHome(Model model) {
		
		System.out.print("Inside homecontroller");		
//		HttpSession session=request.getSession();
//		session.setAttribute("roleName", "staff");
		return "DashBoard";
	}	
	
	@RequestMapping(value = "/")
	public ModelAndView createNewStudent() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/login/create.html");		
		return mav;
	}
	
	@RequestMapping(value = "/reportsto", method = RequestMethod.GET)
	public String displayHierachy(Model model) {
		return "ManageHeirachy";
	}

	@RequestMapping(value = "/type")
	public String createNewType() {
		
		return "leaveType";
	}

}

