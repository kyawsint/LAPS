package nus.iss.laps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import nus.iss.laps.model.Login;

import nus.iss.laps.service.LoginService;

import nus.iss.laps.web.validator.LoginValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.laps.web.validator.*;


@Controller
@RequestMapping(value="/login")

public class LoginController {

	
	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginValidator loginValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}
	
	
    @RequestMapping(value="/create", method = RequestMethod.GET)	
	public ModelAndView loginPage(){
	ModelAndView mav = new ModelAndView("home", "login",new Login());
	mav.addObject("invalidUser", "");
	return mav;
	}
    
    @RequestMapping(value="/create", method = RequestMethod.POST)	
    public ModelAndView verifyLogin(@ModelAttribute @Valid Login login,
			BindingResult result, final RedirectAttributes redirectAttributes,HttpServletRequest request) {
    	HttpSession session=request.getSession();
		if (result.hasErrors()){
			return new ModelAndView("home");
		}
		ModelAndView mav = new ModelAndView();
		String message = login.getUserId();

		List<Login> userDetails=loginService.verifyUserCredentials(login.getUserId(), login.getPassword());
		if(userDetails.isEmpty()){			
			session.setAttribute("invalidUser", "Invalid username and password");
			return new ModelAndView("home");
		}else{
			mav.addObject("roleName",userDetails.get(0).getRoleName());
			
	    	session.setAttribute("username", userDetails.get(0).getUserId());
	    	session.setAttribute("roleName", userDetails.get(0).getRoleName());
			mav.setViewName("redirect:/DashBoard");			
		}
			
		redirectAttributes.addFlashAttribute("UserName", message);
		return mav;
	}
    

	
    
    
    

	
}
