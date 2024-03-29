package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.RentAreaEntity;

public interface RentareaRepository extends JpaRepository<RentAreaEntity, Long>{
	
	List<RentAreaEntity> findByBuilding_Id (Long buildingId);

}
