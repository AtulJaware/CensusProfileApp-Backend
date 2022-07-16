package com.project.CensusProfiling.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.Member;

@Repository
public interface IMemberRepo extends JpaRepository<Member,Integer>{
	
	List<Member> findByFirstName(String fname);
	
	List<Member> findByLastName(String lname);
	
	List<Member> findByDOB(LocalDate date);
	
}
