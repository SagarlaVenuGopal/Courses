package com.example.Project.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Project.dto.Clients;


public interface ClientsRepo extends JpaRepository<Clients, Integer>{
	
	 @Query("SELECT c FROM Clients c WHERE c.clientName = :clientName")
	    Optional<Clients> findByName(String clientName);
	 

	

}
