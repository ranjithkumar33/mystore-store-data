package com.microapps.ebusiness.mystore.application.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "activity")
public class Activity {
	
	public Activity() {
			
	}
	
	public Activity(Double amount, java.util.Date createdOn) {
		this.totalPurchaseAmount=amount;
		this.createdOn=new Timestamp(createdOn.getTime());
}
	

	public Activity(String name, Customer customer, String itemGroup, float amount, int earnedPoints, String createdBy) {
			this.name=name;
			this.customer=customer;
			this.itemGroup=itemGroup;
			this.amount=amount;
			this.earnedPoints=earnedPoints;
			this.createdBy=createdBy;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Transient
	private float revenue;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	@Column(name = "item_group")
	private String itemGroup;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "earned_points")
	private int earnedPoints;
	
	@Column(name = "created_on")
	private Timestamp createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Transient
	private Double totalPurchaseAmount;

	public Double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}

	public void setTotalPurchaseAmount(Double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(int earnedPoints) {
		this.earnedPoints = earnedPoints;
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


	public float getRevenue() {
		return revenue;
	}


	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

}
