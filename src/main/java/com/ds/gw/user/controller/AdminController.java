package com.ds.gw.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.gw.user.DeptDto;
import com.ds.gw.user.HUDto;
import com.ds.gw.user.HobbyDto;
import com.ds.gw.user.UserDto;
import com.ds.gw.user.service.DeptService;
import com.ds.gw.user.service.HobbyService;
import com.ds.gw.user.service.OpperService;
import com.ds.gw.user.service.UserService;

import javax.annotation.Resource;

@Controller
public class AdminController {
	@Resource(name="userService")
	UserService userservice;
	@Resource(name="hobbyService")
	HobbyService hobbyservice;
	@Resource(name="opperService")
	OpperService opperservice;
	@Resource(name="deptService")
	DeptService deptservice;
	
	@RequestMapping(value="/admin")
	public String getList(UserDto dto, Model model) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);
		model.addAttribute("searchKeyword", dto.getSearchKeyword());
//		System.out.println("searchkeyword"+dto.getSearchKeyword());
		return "admin";
	}
	
	// 상세정보 보기
	@RequestMapping("/admin/{user_id}")
	public String getView(@PathVariable String user_id ,UserDto dto,DeptDto d_dto, HobbyDto h_dto, HUDto hu_dto, Model model ) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);

		List<HobbyDto> hobbylist = hobbyservice.getHobby(h_dto);
		model.addAttribute("hobbylist", hobbylist);
		
		List<HUDto> uhlist = opperservice.userHobby(hu_dto);
		StringBuffer userHobby = new StringBuffer();
		for(int i=0; i < uhlist.size(); i++) {
			userHobby.append(uhlist.get(i).getOpper_cd());
		}

		model.addAttribute("userHobby", userHobby);
		
		List<DeptDto> deptlist = deptservice.getDept(d_dto);
		model.addAttribute("deptlist", deptlist);
		UserDto resultdto = userservice.getView(dto);
		model.addAttribute("userDto", resultdto);
		
		model.addAttribute("searchKeyword", dto.getSearchKeyword());
		return "view";
		
	}
	
	// update 정보 저장
	@RequestMapping(value="/admin/save/{user_id}")
	public String updateUser(@PathVariable String user_id,UserDto dto,DeptDto d_dto, HUDto hu_dto, Model model ) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);
		
		userservice.updateUser(dto);
		
		opperservice.deleteHobby(hu_dto);
		String hulist = hu_dto.getHobby_cd();
		String[] hulist2 = hulist.split(",");
		for (int i=0; i<hulist2.length; i++) {
			hu_dto.setHobby_cd(hulist2[i]);
			opperservice.insertHobby(hu_dto);
		}
		
		return "redirect:/admin";
		
	}
	
	@RequestMapping("/admin/delete/{user_id}")
	public String deleteUser(@PathVariable String user_id,UserDto dto,DeptDto d_dto, Model model ) {
		List<UserDto> list = userservice.getList(dto);
		model.addAttribute("getList", list);
		
		
		userservice.deleteUser(dto);		
		return "redirect:/admin";
		
	}
	
	@ModelAttribute("hobbylist")
	public List<HobbyDto> getHobby(HobbyDto dto){
		List<HobbyDto> hlist = hobbyservice.getHobby(dto);
		return hlist;
	}
	
	
	
	
}
