package com.bkc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "homepage";
	}
	
	@GetMapping("/login")
	public String loginpage() {
		return "loginpage";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signuppage";
	}
	
//	@GetMapping("/process-login")
//	public ModelAndView processlogin() {
//		ModelAndView mv = new ModelAndView("profile");
//		
//		return mv;
//	}
}
