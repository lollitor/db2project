package com.project.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="package")
public class ServicePackage {
	
	@Id @Column(name = "package")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "package_has_validity_period", joinColumns = {
			@JoinColumn(name = "package")}, inverseJoinColumns = {
					@JoinColumn(name = "validity_period")
			})
	private List<ValidityPeriod> validityPeriods;
	
	@ManyToMany
	@JoinTable(name = "package_has_fixed_phone", joinColumns = {
			@JoinColumn(name = "package")}, inverseJoinColumns = {
					@JoinColumn(name = "fixed_phone")
			})
	private List<FixedPhone> fixedPhones;
	
	@ManyToMany
	@JoinTable(name = "package_has_fixed_internet", joinColumns = {
			@JoinColumn(name = "package")}, inverseJoinColumns = {
					@JoinColumn(name = "fixed_internet")
			})
	private List<FixedInternet> fixedInternets;
	
	@ManyToMany
	@JoinTable(name = "package_has_mobile_internet", joinColumns = {
			@JoinColumn(name = "package")}, inverseJoinColumns = {
					@JoinColumn(name = "mobile_internet")
			})
	private List<MobileInternet> mobileInternets;
	
	@ManyToMany
	@JoinTable(name = "package_has_mobile_phone", joinColumns = {
			@JoinColumn(name = "package")}, inverseJoinColumns = {
					@JoinColumn(name = "mobile_phone")
			})
	private List<MobilePhone> mobilePhones;
	
	@ManyToMany
	@JoinTable(name = "package_has_optional_product", joinColumns = {
			@JoinColumn(name = "package")}, inverseJoinColumns = {
					@JoinColumn(name = "optional_product")
			})
	private List<OptionalProduct> optionalProducts;
	
	
	@OneToMany(mappedBy = "servicePackage")
	private List<Subscription> subscriptions;


	public ServicePackage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<ValidityPeriod> getValidityPeriods() {
		return validityPeriods;
	}


	public void setValidityPeriods(List<ValidityPeriod> validityPeriods) {
		this.validityPeriods = validityPeriods;
	}


	public List<FixedPhone> getFixedPhones() {
		return fixedPhones;
	}


	public void setFixedPhones(List<FixedPhone> fixedPhones) {
		this.fixedPhones = fixedPhones;
	}


	public List<FixedInternet> getFixedInternets() {
		return fixedInternets;
	}


	public void setFixedInternets(List<FixedInternet> fixedInternets) {
		this.fixedInternets = fixedInternets;
	}


	public List<MobileInternet> getMobileInternets() {
		return mobileInternets;
	}


	public void setMobileInternets(List<MobileInternet> mobileInternets) {
		this.mobileInternets = mobileInternets;
	}


	public List<MobilePhone> getMobilePhones() {
		return mobilePhones;
	}


	public void setMobilePhones(List<MobilePhone> mobilePhones) {
		this.mobilePhones = mobilePhones;
	}


	public List<OptionalProduct> getOptionalProducts() {
		return optionalProducts;
	}


	public void setOptionalProducts(List<OptionalProduct> optionalProducts) {
		this.optionalProducts = optionalProducts;
	}


	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}


	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	

}
