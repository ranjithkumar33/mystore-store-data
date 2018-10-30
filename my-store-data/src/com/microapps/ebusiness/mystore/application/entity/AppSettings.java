package com.microapps.ebusiness.mystore.application.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "app_settings")
public class AppSettings {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	
	@Column(name = "mpf")
	private float mpf;
	
	@Column(name = "pmf")
	private float pmf;
	
	@Column(name = "rtp")
	private int rtp;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "created_on")
	private Timestamp createdOn;
	
	@Column(name = "created_by")
	private String createdBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMpf() {
		return mpf;
	}

	public void setMpf(float mpf) {
		this.mpf = mpf;
	}

	public float getPmf() {
		return pmf;
	}

	public void setPmf(float pmf) {
		this.pmf = pmf;
	}

	public int getRtp() {
		return rtp;
	}

	public void setRtp(int rtp) {
		this.rtp = rtp;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
