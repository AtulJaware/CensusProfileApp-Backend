package com.project.CensusProfiling.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.MemberEntity;

@Repository
public interface IMemberRepo extends JpaRepository<MemberEntity,Integer>{
	
	List<MemberEntity> findByFirstName(String fname);
	
	List<MemberEntity> findByLastName(String lname);
	
	List<MemberEntity> findByDOB(LocalDate date);
	
}
