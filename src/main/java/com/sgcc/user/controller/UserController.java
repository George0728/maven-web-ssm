package com.sgcc.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sgcc.user.pojo.User;
import com.sgcc.user.service.UserService;

@Controller
public class UserController {
	
	
	@Resource
	private UserService userService;
	@RequestMapping("/getUserById" )
	public String testShowUser(@RequestParam(value = "id") Integer id ,Model model)  {
		System.out.println("id:"+id);
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		
		return "showUser";
	}

}
