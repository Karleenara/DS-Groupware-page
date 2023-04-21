package com.ds.gw.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.gw.user.DeptDto;
import com.ds.gw.user.repository.DeptDao;

import javax.annotation.Resource;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Resource(name="deptDao")
	DeptDao dao;

	@Override
	public List<DeptDto> getDept(DeptDto dto) {
		return dao.getDept(dto);
	}
}
