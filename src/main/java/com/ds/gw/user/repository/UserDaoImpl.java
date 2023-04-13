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
	
	
}
