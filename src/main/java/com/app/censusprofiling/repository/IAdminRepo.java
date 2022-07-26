package com.app.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.censusprofiling.entity.Admin;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Integer>{

	@Query(value="select * from admin inner join login on admin.email=login.email where admin.email=:email", nativeQuery=true)
	Admin getAdminByEmail(@Param("email") String email);

}
