package com.bkc.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bkc.bean.EditEmpBean;
import com.bkc.bean.EmployeeBean;
import com.bkc.model.Employee;
import com.bkc.service.EmployeeService;

@Controller
public class MainController {
	@Autowired
	private EmployeeService empService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/registerpage")
	public String registerpage() {
		return "registerpage";
	}
	
	//save userDetail
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute(name="empBean") EmployeeBean empBean) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(empBean);
		empService.saveEmployeeDetails(empBean);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/users")
	public ModelAndView userList(Model m) {
		ModelAndView mv = new ModelAndView();
		List<EmployeeBean> usersList = empService.getUsersList();
//		System.out.println(usersList);
	    m.addAttribute("userslist", usersList);
		mv.setViewName("userlist");
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		empService.deleteUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping("/edit/{id}")
	public String editEmp(@PathVariable Integer id ,ModelMap m) {
//		EmployeeBean user = (EmployeeBean) empService.getUser(id);
		
		List<EmployeeBean> user = empService.getUser(id);
//		System.out.println(" "+user.getEmail()+" "+user.getName()+" "+user.getMobile());
//		System.out.println(user);
		m.addAttribute("list", user);
		return "editpage";
	}
	
	@RequestMapping("/update")
	public String updateEmp(@ModelAttribute EditEmpBean editEmpBean) {
		boolean isUpdated = empService.updateUser(editEmpBean);
		if(isUpdated == true) {
			System.out.println("User updated successfully..");
		}else {
			System.out.println("Something went wrong..");
		}
		return "redirect:/users";
	}
}
