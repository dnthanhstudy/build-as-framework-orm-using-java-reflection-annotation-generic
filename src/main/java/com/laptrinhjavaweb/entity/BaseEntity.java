package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "createddate", columnDefinition = "TIMESTAMP", updatable = false)
	private Date createddate;

	@Column(name = "createdby", updatable = false)
	private String createdby;

	@Column(name = "modifieddate", columnDefinition = "TIMESTAMP", insertable = false)
	private Date modifieddate;

	@Column(name = "modifiedby", insertable = false)
	private String modifiedby;

	@Column(name = "status", columnDefinition = "INTEGER")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
