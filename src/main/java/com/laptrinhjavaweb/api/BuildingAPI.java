package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/buildings")
public class BuildingAPI {

	@Autowired
	private IBuildingService buildingService;

//	@GetMapping
//	public List<BuildingDTO> searchs (
//			@RequestParam Map<String, Object> params,
//			@RequestParam(name = "types", required = false) String[] types) {
//
//		params.remove("types");
//		List<BuildingDTO> results = buildingService.searchs(params, types);
//		return results;
//	}

	@GetMapping
	public List<BuildingDTO> findAll () {
		List<BuildingDTO> results = buildingService.findAll();
		return results;
	}
}
