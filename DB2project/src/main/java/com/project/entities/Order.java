package com.project.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="order")
public class Order {
	
	@Id @Column(name = "order")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private Timestamp timestamp;
	
	private float value;
	
	
	private int rejected;
	
	private Byte valid; // Equivalent of TINYINT
	
	@OneToOne
	@JoinColumn(name = "subscription")
	private Subscription serviceSubscription;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getRejected() {
		return rejected;
	}

	public void setRejected(int rejected) {
		this.rejected = rejected;
	}

	public Byte getValid() {
		return valid;
	}

	public void setValid(Byte valid) {
		this.valid = valid;
	}

	public Subscription getServiceSubscription() {
		return serviceSubscription;
	}

	public void setServiceSubscription(Subscription serviceSubscription) {
		this.serviceSubscription = serviceSubscription;
	}
	
	

}
