package com.project.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="mobile_phone")
public class MobilePhone {
	
	@Id @Column(name = "mobile_phone")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int min;
	
	private int sms;
	
	@Column(name = "min_fee")
	private float minExtraFee;
	
	@Column(name = "sms_fee")
	private float smsExtraFee;
	
	@ManyToMany(mappedBy = "mobilePhones")
	private List<ServicePackage> servicePackages;

	public MobilePhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSms() {
		return sms;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	public float getMinExtraFee() {
		return minExtraFee;
	}

	public void setMinExtraFee(float minExtraFee) {
		this.minExtraFee = minExtraFee;
	}

	public float getSmsExtraFee() {
		return smsExtraFee;
	}

	public void setSmsExtraFee(float smsExtraFee) {
		this.smsExtraFee = smsExtraFee;
	}

	public List<ServicePackage> getServicePackages() {
		return servicePackages;
	}

	public void setServicePackages(List<ServicePackage> servicePackages) {
		this.servicePackages = servicePackages;
	}
	
	

}
