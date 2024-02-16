package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ReantareaDTO;
import com.laptrinhjavaweb.service.IBuildingService;

@RestController
@RequestMapping("/api/rentareas")

public class ReantareaAPI {
	
	@Autowired
	private IBuildingService buildingService;

	@GetMapping
	public List<ReantareaDTO> findAll(
			@RequestParam(value = "buildingid", required = false) Long buildingId){
		List<ReantareaDTO> results = buildingService.findAllByBuildingid(buildingId);
		return results;
	}
}
