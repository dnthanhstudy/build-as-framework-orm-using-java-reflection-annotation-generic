package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;

	@Column(name = "street")
	private String street;
	
	@Column(name = "ward")
	private String ward;

	@Column(name = "structure")
	private String structure;

	@Column(name = "numberofbasement")
	private Integer numberofbasement;

	@Column(name = "floorarea")
	private Integer floorarea;

	@Column(name = "direction")
	private String direction;

	@Column(name = "level")
	private String level;

	@Column(name = "rentprice")
	private Integer rentprice;

	@Column(name = "rentpricedescription", columnDefinition = "TEXT")
	private String rentpircedescription;

	@Column(name = "servicefee")
	private String servicefee;

	@Column(name = "carfee")
	private String carfee;

	@Column(name = "motofee")
	private String motofee;

	@Column(name = "overtimefee")
	private String overtimefee;

	@Column(name = "waterfee")
	private String waterfee;

	@Column(name = "electricityfee")
	private String electricityfee;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "payment")
	private String payment;

	@Column(name = "renttime")
	private String renttime;

	@Column(name = "decorationtime")
	private String decorationtime;

	@Column(name = "brokeragefee", precision = 10, scale = 2)
	private Double brokeragefee;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "linkofbuilding")
	private String linkofbuilding;
	
	@Column(name = "map")
	private String map;
	
	@Column(name = "avatar")
	private String avatar;

	@Column(name = "namemanager")
	private String namemanager;

	@Column(name = "phonemanager")
	private String phonemanager;
	
	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district;
	
	@OneToMany(mappedBy ="building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreas = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getNumberofbasement() {
		return numberofbasement;
	}

	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getRentprice() {
		return rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	public String getRentpircedescription() {
		return rentpircedescription;
	}

	public void setRentpircedescription(String rentpircedescription) {
		this.rentpircedescription = rentpircedescription;
	}

	public String getServicefee() {
		return servicefee;
	}

	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}

	public String getCarfee() {
		return carfee;
	}

	public void setCarfee(String carfee) {
		this.carfee = carfee;
	}

	public String getMotofee() {
		return motofee;
	}

	public void setMotofee(String motofee) {
		this.motofee = motofee;
	}

	public String getOvertimefee() {
		return overtimefee;
	}

	public void setOvertimefee(String overtimefee) {
		this.overtimefee = overtimefee;
	}

	public String getWaterfee() {
		return waterfee;
	}

	public void setWaterfee(String waterfee) {
		this.waterfee = waterfee;
	}

	public String getElectricityfee() {
		return electricityfee;
	}

	public void setElectricityfee(String electricityfee) {
		this.electricityfee = electricityfee;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRenttime() {
		return renttime;
	}

	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}

	public String getDecorationtime() {
		return decorationtime;
	}

	public void setDecorationtime(String decorationtime) {
		this.decorationtime = decorationtime;
	}

	public Double getBrokeragefee() {
		return brokeragefee;
	}

	public void setBrokeragefee(Double brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLinkofbuilding() {
		return linkofbuilding;
	}

	public void setLinkofbuilding(String linkofbuilding) {
		this.linkofbuilding = linkofbuilding;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public List<RentAreaEntity> getRentAreas() {
		return rentAreas;
	}

	public void setRentAreas(List<RentAreaEntity> rentAreas) {
		this.rentAreas = rentAreas;
	}
}
