package com.ds.gw.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.gw.user.DeptDto;
import com.ds.gw.user.UserDto;
import com.ds.gw.user.service.UserService;

import jakarta.annotation.Resource;

@Controller
public class AdminController {
	@Resource(name="userService")
	UserService userservice;
	
	@RequestMapping(value="/admin")
	public String getList(UserDto dto, Model model) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);
		return "admin";
	}
	
	@RequestMapping("/admin/{user_id}")
	public String getView(@PathVariable String user_id ,UserDto dto, Model model ) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);
		UserDto resultdto = userservice.getView(user_id);
		model.addAttribute("userDto", resultdto);
		return "detail";
		
	}
	
	
}
