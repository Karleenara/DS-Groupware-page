package com.ds.gw.user.service;

import java.util.List;

import com.ds.gw.user.HUDto;
import com.ds.gw.user.HobbyDto;

public interface HobbyService {
	List<HobbyDto> getHobby(HobbyDto h_dto);
	void insertHobby(HUDto hu_dto);
	List<HUDto> userHobby(HUDto hu_dto);
}
