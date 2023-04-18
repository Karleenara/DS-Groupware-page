package com.ds.gw.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ds.gw.user.DeptDto;
import com.ds.gw.user.HUDto;
import com.ds.gw.user.HobbyDto;
import com.ds.gw.user.UserDto;
import com.ds.gw.user.service.DeptService;
import com.ds.gw.user.service.HobbyService;
import com.ds.gw.user.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@Controller
public class UserController {
	@Resource(name="userService")
	UserService userservice;
	@Resource(name="hobbyService")
	HobbyService hobbyservice;
	@Resource(name="deptService")
	DeptService deptservice;
	

	// 사용자 정보 가져오기
	@RequestMapping("/list")
	public String getList(UserDto dto, Model model) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);
		System.out.println(list);
		
		return "list";
	}
	
	// 사용자포털: (wirte)등록 페이지로 이동
	@RequestMapping(value="/user")
	public String write(UserDto u_dto,DeptDto d_dto, Model model) {
		List<DeptDto> deptlist = deptservice.getDept(d_dto);
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("UserDto", u_dto );
		return "write";
	}
	
	// 등록내용 DB에 저장
	@RequestMapping(value="/user/save")
	public String save(UserDto dto, HUDto hu_dto, Model model) {
		userservice.insertUser(dto);
		//hobbyservice.insertHobby(hu_dto);
		return "redirect:/";
		
	}
	
	// 취미정보 가져오기
	@ModelAttribute("hobbylist")
	public List<HobbyDto> getHobby(HobbyDto dto){
		List<HobbyDto> hlist = hobbyservice.getHobby(dto);
		return hlist;
	}
	
//	// 부서정보 가져오기
//	@ModelAttribute("deptlist")
//	public List<DeptDto> getDept(DeptDto dto){
//		List<DeptDto> dlist = deptservice.getDept(dto);
//		return dlist;
//	}
	
	

}
