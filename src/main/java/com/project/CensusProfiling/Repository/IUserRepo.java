package com.project.CensusProfiling.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer>{
	
	
}
