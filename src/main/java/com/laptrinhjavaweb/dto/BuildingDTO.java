package com.laptrinhjavaweb.dto;

import java.util.Date;

public class BuildingDTO {
	
	private Date createddate;

	private String name;

	private Integer floorarea;
	
	private String address;
	
	private String namemanager;
	
	private String phonemanager;
	
	private String rentarea;
	
	private Integer rentprice;
	
	private String servicePrice;
	
	private Double brokeragefee;

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNamemanager() {
		return namemanager;
	}

	public void setNamemanager(String namemanager) {
		this.namemanager = namemanager;
	}

	public String getPhonemanager() {
		return phonemanager;
	}

	public void setPhonemanager(String phonemanager) {
		this.phonemanager = phonemanager;
	}

	public String getRentarea() {
		return rentarea;
	}

	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
	}

	public Integer getRentprice() {
		return rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	public String getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Double getBrokeragefee() {
		return brokeragefee;
	}

	public void setBrokeragefee(Double brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
}
