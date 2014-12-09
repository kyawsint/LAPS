package nus.iss.laps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/logout")

public class LogoutController {
	
@RequestMapping(value="/dologout",method=RequestMethod.GET)
public ModelAndView doLogout(HttpServletRequest request){
	HttpSession session=request.getSession();
	
	ModelAndView mav=new ModelAndView();
	//ModelAndView mav = new ModelAndView("ClaimsList");
	mav.setViewName("redirect:/login/create.html");
	session.invalidate();
	return mav;
	
}
}
