package com.sa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sa.bean.EditToDoBean;
import com.sa.bean.ToDoBean;
import com.sa.service.ToDoService;

@Controller
public class AppController {

	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)
	public String home(Model m) {
		List<ToDoBean> allToDo = toDoService.getAllToDo();
		m.addAttribute("list", allToDo);
		return "index";
	}
	
	@RequestMapping("/save")
	public String saveToDo(@ModelAttribute ToDoBean toDoBean) {
		boolean issaved = toDoService.saveToDo(toDoBean);

		if(issaved==true) {
			System.out.println("ToDo added successfully");
		}else {
			System.out.println("Something went wrong");
		}
		return "redirect:/home";
	}
	
	@RequestMapping("/edit/{id}")
	public String editToDo(@PathVariable Integer id, Model m) {
		List<ToDoBean> toDoById = toDoService.getToDoById(id);
		System.out.println(toDoById);
		m.addAttribute("list", toDoById);
		return "edittodo";
	}
	
	@RequestMapping("/open/{id}")
	public String viewToDo(@PathVariable Integer id, Model m) {
		List<ToDoBean> toDoById = toDoService.getToDoById(id);
		System.out.println(toDoById);
		m.addAttribute("list", toDoById);
		return "todo";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteToDo(@PathVariable Integer id) {
		boolean deleteToDo = toDoService.deleteToDo(id);
		if(deleteToDo==true) {
			System.out.println("ToDo deleted successfully");
		}else {
			System.out.println("Some thing wrong while deleting");
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public String updateToDo(@ModelAttribute EditToDoBean editToDoBean) {
		System.out.println(editToDoBean.getTitle());
		System.out.println(editToDoBean.getDescription());
		boolean deleteToDo = toDoService.updateToDo(editToDoBean);
		if(deleteToDo==true) {
			System.out.println("ToDo updated successfully");
		}else {
			System.out.println("Some thing wrong while updating");
		}
		return "redirect:/home";
	}
	
}
