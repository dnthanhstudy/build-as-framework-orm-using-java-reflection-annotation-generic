package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO convertToDTO (UserEntity entity) {
		UserDTO result = modelMapper.map(entity, UserDTO.class);
		return result;
	}
}
