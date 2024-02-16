package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.ReantareaDTO;

public interface IBuildingService {

	List<BuildingDTO> findAll();
	
	List<ReantareaDTO> findAllByBuildingid(Long buildingid);
	
	void save(BuildingDTO newBuildingDTO);
	
	List<BuildingDTO> searchs (Map<String, Object> params, String[] types);
}
