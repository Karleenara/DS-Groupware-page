package com.ds.gw.user.service;

import java.util.List;

import com.ds.gw.user.HUDto;

public interface OpperService {
	void insertHobby(HUDto hu_dto);
	List<HUDto> userHobby(HUDto hu_dto);
	void deleteHobby(HUDto hu_dto);
}
