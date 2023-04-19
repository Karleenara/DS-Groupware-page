package com.ds.gw.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.user.UserDto;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<UserDto> getList(UserDto dto) {
		return sm.selectList("getList",dto);
	}

	@Override
	public void insertUser(UserDto dto) {
		sm.insert("insertUser",dto);
	}

	@Override
	public UserDto getView(String user_id) {
		return sm.selectOne("getView", user_id);
	}

	@Override
	public void updateUser(UserDto dto) {
		sm.update("updateUser", dto);
	}

	@Override
	public void deleteUser(UserDto dto) {
		sm.delete("deleteUser", dto);
	}


	
}
