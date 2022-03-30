package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.ServicePackage;

public interface ServicePackageRepository extends JpaRepository<ServicePackage,Integer> {
	
	//eventuali named queries

}
