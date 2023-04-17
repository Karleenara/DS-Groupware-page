package com.ds.gw.user.repository;

import java.util.List;

import com.ds.gw.user.DeptDto;

public interface DeptDao {
	List<DeptDto> getDept(DeptDto dto);
}
