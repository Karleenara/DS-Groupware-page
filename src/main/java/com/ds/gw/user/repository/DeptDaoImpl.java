package com.ds.gw.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.user.DeptDto;


@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<DeptDto> getDept(DeptDto dto) {
		return sm.selectList("getDept", dto);
	}
	
}
