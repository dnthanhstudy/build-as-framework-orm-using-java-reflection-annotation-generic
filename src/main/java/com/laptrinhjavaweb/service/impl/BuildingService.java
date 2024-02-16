package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;
import com.laptrinhjavaweb.repository.jdbc.entity.BuildingJDBCEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.RentareaConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.ReantareaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentareaRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.MapUtils;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private RentareaConverter rentareaConvert;

	@Autowired
	private RentareaRepository rentareRepository;

	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private IBuildingJDBC buildingJDBC;

	@Override
	public List<BuildingDTO> findAll() {
//		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
//		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item))
//				.collect(Collectors.toList());
//		return results;

		List<BuildingJDBCEntity> buildingEntities = buildingJDBC.findAll();
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertJdbcEntityToDTO(item))
				.collect(Collectors.toList());
		return results;
	}

	@Override
	public List<ReantareaDTO> findAllByBuildingid(Long buildingid) {
		List<RentAreaEntity> reantareEntities = rentareRepository.findByBuilding_Id(buildingid);
		List<ReantareaDTO> results = reantareEntities.stream().map(item -> rentareaConvert.convertToDTO(item))
				.collect(Collectors.toList());
		return results;
	}

	@Override
	@Transactional
	public void save(BuildingDTO newBuildingDTO) {
		BuildingEntity result = buildingConverter.convertToEntity(newBuildingDTO);
		buildingRepository.save(result);
	}

	@Override
	public List<BuildingDTO> searchs(Map<String, Object> params, String[] types) {
		BuildingSearchBuilder buildingSearchBuilder = convertToBuildingSearchBuilder(params, types);
		List<BuildingEntity> buildingEntities = buildingRepository.searchs(buildingSearchBuilder);
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item))
				.collect(Collectors.toList());
		return results;
	}

	private BuildingSearchBuilder convertToBuildingSearchBuilder(Map<String, Object> params, String[] types) {
		BuildingSearchBuilder result = new BuildingSearchBuilder.Builder()
				.setName(MapUtils.getObject(params, "name", String.class))
				.setFlooarea(MapUtils.getObject(params, "flooarea", Integer.class))
				.setWard(MapUtils.getObject(params, "ward", String.class))
				.setStreet(MapUtils.getObject(params, "street", String.class))
				.setDirection(MapUtils.getObject(params, "direction", String.class))
				.setLevel(MapUtils.getObject(params, "level", String.class))
				.setNamemanager(MapUtils.getObject(params, "namemanager", String.class))
				.setPhonemanager(MapUtils.getObject(params, "phonemanager", String.class))
				.setDistrict(MapUtils.getObject(params, "district", String.class))
				.setNumberofbasement(MapUtils.getObject(params, "numberofbasement", Integer.class))
				.setStaffid(MapUtils.getObject(params, "staffid", Long.class))
				.setTypes(types)
				.setRentpricefrom(MapUtils.getObject(params, "rentpricefrom", Integer.class))
				.setRentpriceto(MapUtils.getObject(params, "rentpriceto", Integer.class))
				.setRentareafrom(MapUtils.getObject(params, "rentareafrom", Integer.class))
				.setRentareato(MapUtils.getObject(params, "rentareato", Integer.class))
				.build();
		return result;
	}
}
