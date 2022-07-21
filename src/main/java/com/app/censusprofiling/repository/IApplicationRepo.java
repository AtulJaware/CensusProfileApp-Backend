package com.app.censusprofiling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.censusprofiling.entity.Application;

@Repository
public interface IApplicationRepo extends JpaRepository<Application,Integer>{
	
	List<Application> findByStatus(String status);
	
}
