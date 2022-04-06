package com.project.entities;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="purchase")
public class Order {
	
	@Id @Column(name = "purchase")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private Timestamp timecode;
	
	private float price;
	
	
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

	public Timestamp getTimecode() {
		return timecode;
	}

	public void setTimecode(Timestamp timecode) {
		this.timecode = timecode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public void setValid(Byte b) {
		this.valid = b;
	}

	public Subscription getServiceSubscription() {
		return serviceSubscription;
	}

	public void setServiceSubscription(Subscription serviceSubscription) {
		this.serviceSubscription = serviceSubscription;
	}
	
	

}
