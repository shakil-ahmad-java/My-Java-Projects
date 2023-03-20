package com.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sa.model.UserProfile;
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
	public String saveUser(@ModelAttribute UserProfile user) {
//		System.out.println(user.getFullname());
//		System.out.println(user.getMobile());
		boolean saveUser = userProfileService.saveUser(user);
		if(saveUser==true) {
			System.out.println("user saved successfully..");
		}else {
			System.out.println("Someting went wrong..");
		}
		return "redirect:/login";
	}
	
}
