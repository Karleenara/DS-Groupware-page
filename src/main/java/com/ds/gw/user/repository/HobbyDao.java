package com.ds.gw.user.repository;

import java.util.List;

import com.ds.gw.user.HUDto;
import com.ds.gw.user.HobbyDto;

public interface HobbyDao {
	List<HobbyDto> getHobby(HobbyDto dto);
	void insertHobby(HUDto hu_dto);
	List<HUDto> userHobby(HUDto hu_dto);
}
