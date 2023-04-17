package com.ds.gw.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.gw.user.HobbyDto;
import com.ds.gw.user.repository.HobbyDao;

import jakarta.annotation.Resource;

@Service("hobbyService")
public class HobbyServiceImpl implements HobbyService {
	@Resource(name="hobbyDao")
	HobbyDao dao;

	@Override
	public List<HobbyDto> getHobby(HobbyDto dto) {
		return dao.getHobby(dto);
	}


}
