package com.microapps.ebusiness.mystore.application.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "customer")
public class Customer {
	
	public Customer() {
		
	}
	
	public Customer(Long id, String name, java.util.Date createdOn, Double totalPurchaseAmount, Character gender) {
		this.name=name;
		this.id=id;
		this.createdOn=new Timestamp(createdOn.getTime());
		this.totalPurchaseAmount=totalPurchaseAmount;
		this.gender=gender;
	}
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mobile", unique=true)
	private String mobile;
	
	@Column(name = "cardnum", unique=true)
	private String cardNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "status")
	private boolean status;
	
	@OneToMany(mappedBy = "customer",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Activity> activities;
	
	@Column(name = "created_on")
	private Timestamp createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Transient
	private Double totalPurchaseAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}

	public void setTotalPurchaseAmount(Double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

}
