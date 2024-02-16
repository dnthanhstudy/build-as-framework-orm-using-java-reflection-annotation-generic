package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;

	@GetMapping("/api/users")
	public List<UserDTO> findAll(
			@RequestParam(name = "buildingid", required = false) Long buildingid,
			@RequestParam(name = "role", required = false) String rolecode){
		List<UserDTO> results = new ArrayList<>();
		if(rolecode != null) {
			results = userService.findAllByRoleCode(rolecode);
		}
		return results;
	}
}
