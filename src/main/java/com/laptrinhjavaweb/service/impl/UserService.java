package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserDTO> findAllByRoleCode(String roleCode) {
		List<UserEntity> users = userRepository.findAllByRoles_Code(roleCode);
		List<UserDTO> results = users.stream().map(item -> userConverter.convertToDTO(item)).collect(Collectors.toList());
		return results;
	}

}
