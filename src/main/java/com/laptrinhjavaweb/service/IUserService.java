package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {

	List<UserDTO> findAllByRoleCode (String roleCode);
}
