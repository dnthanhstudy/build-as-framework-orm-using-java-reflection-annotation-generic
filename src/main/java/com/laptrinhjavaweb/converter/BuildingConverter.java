package com.laptrinhjavaweb.converter;

import java.util.stream.Collectors;

import com.laptrinhjavaweb.repository.jdbc.entity.BuildingJDBCEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

@Component
public class BuildingConverter {
	
	@Autowired
    private ModelMapper modelMapper;


	public BuildingDTO convertToDTO (BuildingEntity entity) {
		BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
		result.setAddress(entity.getStreet() + " - " + entity.getWard() + " - " + entity.getDistrict().getName());
		String rentarea = entity.getRentAreas().stream().map(
				item -> item.getValue() + "m2").collect(Collectors.joining(","));
		result.setRentarea(rentarea);
		return result;
	}
	
	public BuildingEntity convertToEntity (BuildingDTO dto) {
		BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
		return result;
	}


	public BuildingDTO convertJdbcEntityToDTO (BuildingJDBCEntity entity) {
		BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
		return result;
	}
}
