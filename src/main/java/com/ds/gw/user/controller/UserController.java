package com.ds.gw.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ds.gw.user.UserDto;
import com.ds.gw.user.service.UserService;

import jakarta.annotation.Resource;

@Controller
public class UserController {
	@Resource(name="userService")
	UserService service;
	
//	@GetMapping("/")
//	public HashMap<String, Object> getList(UserDto dto){
//		HashMap<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("list", service.getList(dto));
//		return resultMap;
//	}
	
	@RequestMapping("/list")
	public String getList(UserDto dto, Model model) {
		List<UserDto> list = service.getList(dto);
		model.addAttribute("getList", list);
		System.out.println(list);
		
		return "index";
	}
	
	
	
}
