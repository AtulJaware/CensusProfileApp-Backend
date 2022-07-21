package com.app.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.censusprofiling.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer>{
	
	
}
