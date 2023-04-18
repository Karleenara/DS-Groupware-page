package com.ds.gw.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.gw.user.UserDto;
import com.ds.gw.user.repository.UserDao;

import jakarta.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	UserDao dao;

	@Override
	public List<UserDto> getList(UserDto dto) {
		return dao.getList(dto);
	}

	@Override
	public void insertUser(UserDto dto) {
		dao.insertUser(dto);
	}

	@Override
	public UserDto getView(String user_id) {
		return dao.getView(user_id);
	}


	
}
