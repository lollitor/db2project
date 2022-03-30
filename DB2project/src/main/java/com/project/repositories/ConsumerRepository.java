package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entities.Consumer;


public interface ConsumerRepository extends JpaRepository<Consumer,Integer>{
	
	
	@Query("SELECT u FROM Consumer u WHERE u.username = ?1 AND u.password=?2")
	public Consumer checkLogin(String username, String password);

}
