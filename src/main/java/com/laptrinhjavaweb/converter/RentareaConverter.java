package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ReantareaDTO;
import com.laptrinhjavaweb.entity.RentAreaEntity;

@Component
public class RentareaConverter {

	@Autowired
	private ModelMapper modelMapper;

	public RentAreaEntity convertToEntity(ReantareaDTO dto) {
		RentAreaEntity result = modelMapper.map(dto, RentAreaEntity.class);
		return result;
	}
	
	public ReantareaDTO convertToDTO (RentAreaEntity entity) {
		ReantareaDTO result = modelMapper.map(entity, ReantareaDTO.class);
		result.setBuildingid(entity.getBuilding().getId());
		return result;
	}
}
