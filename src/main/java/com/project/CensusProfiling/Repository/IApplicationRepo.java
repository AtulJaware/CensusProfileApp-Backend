package com.project.CensusProfiling.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.Application;

@Repository
public interface IApplicationRepo extends JpaRepository<Application,Integer>{
	
	List<Application> findByStatus(String status);
	
}
