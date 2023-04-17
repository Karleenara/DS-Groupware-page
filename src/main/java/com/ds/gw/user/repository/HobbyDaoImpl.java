package com.ds.gw.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.user.HobbyDto;

@Repository("hobbyDao")
public class HobbyDaoImpl implements HobbyDao{
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<HobbyDto> getHobby(HobbyDto dto) {
		return sm.selectList("getHobby", dto);
	}
	
}
