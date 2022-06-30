package com.project.CensusProfiling.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.ApplicationEntity;

@Repository
public interface IApplicationRepo extends JpaRepository<ApplicationEntity,Integer>{
	
	List<ApplicationEntity> findByStatus(String status);
	
}
