package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entities.ServicePackage;

public interface ServicePackageRepository extends JpaRepository<ServicePackage,Integer> {
	
	@Query("SELECT s FROM ServicePackage s ORDER BY s.name")
	public List<ServicePackage> getServices();

}
