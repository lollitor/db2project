package com.project.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="subscription")
public class Subscription {
	
	@Id @Column(name = "subscription")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "activation_date")
	private Date activationDate;
	
	@ManyToOne
	@JoinColumn(name = "consumer")
	private Consumer consumer;
	
	@ManyToMany
	@JoinTable(name = "subscription_has_optional_product", joinColumns = {
			@JoinColumn(name = "subscription")}, inverseJoinColumns = {
					@JoinColumn(name = "optional_product")
			})
	private List<OptionalProduct> optionalProducts;
	
	@ManyToOne
	@JoinColumn(name = "package")
	private ServicePackage servicePackage;
	
	@ManyToOne
	@JoinColumn(name = "validity_period")
	private ValidityPeriod validityPeriod;
	
	@OneToOne(mappedBy = "serviceSubscription")
	private Order order;

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public List<OptionalProduct> getOptionalProducts() {
		return optionalProducts;
	}
	

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public void setOptionalProducts(List<OptionalProduct> optionalProducts) {
		this.optionalProducts = optionalProducts;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public ServicePackage getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(ServicePackage servicePackage) {
		this.servicePackage = servicePackage;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "id: "+this.getId()+" user: "+this.getConsumer().getUsername()+ " validity period: "+this.getValidityPeriod().getMonthlyFee();
	}
	
	

}
