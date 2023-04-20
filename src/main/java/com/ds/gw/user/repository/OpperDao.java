package com.ds.gw.user.repository;

import java.util.List;

import com.ds.gw.user.HUDto;

public interface OpperDao {
	void insertHobby(HUDto hu_dto);
	List<HUDto> userHobby(HUDto hu_dto);
	void deleteHobby(HUDto hu_dto);
}
