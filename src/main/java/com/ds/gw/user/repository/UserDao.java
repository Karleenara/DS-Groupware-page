package com.ds.gw.user.repository;

import java.util.List;

import com.ds.gw.user.UserDto;

public interface UserDao {
	List<UserDto> getList(UserDto dto);
	void insertUser(UserDto dto);
	UserDto getView(String user_id);
	void updateUser(UserDto dto);
	void deleteUser(UserDto dto);
}
