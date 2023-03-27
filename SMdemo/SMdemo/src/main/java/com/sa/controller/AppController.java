package com.sa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.sa.bean.Login;
import com.sa.bean.UserProfileBean;
import com.sa.service.UserProfileService;

@Controller
public class AppController {

	@Autowired
	private UserProfileService userProfileService;
	
	@GetMapping({"/","/home"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "loginpage";
	}
	
	@GetMapping("/create-account")
	public String registerPage() {
		return "registerpage";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String saveUser(@ModelAttribute UserProfileBean userProfileBean) {
//		System.out.println(user.getFullname());
//		System.out.println(user.getMobile());
		boolean saveUser = userProfileService.saveUser(userProfileBean);
		if(saveUser==true) {
			System.out.println("user saved successfully..");
		}else {
			System.out.println("Someting went wrong..");
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value= {"/sign-in"}, method=RequestMethod.POST)
	public ModelAndView signIn(@ModelAttribute(name="loginForm") Login login,Model m, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
}
