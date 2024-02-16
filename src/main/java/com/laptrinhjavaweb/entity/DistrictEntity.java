package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity{
	
	private String code;

	private String name;
	
	@OneToMany(mappedBy ="district", fetch = FetchType.LAZY)
	private List<BuildingEntity> rentAreas = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<BuildingEntity> getRentAreas() {
		return rentAreas;
	}

	public void setRentAreas(List<BuildingEntity> rentAreas) {
		this.rentAreas = rentAreas;
	}
}
