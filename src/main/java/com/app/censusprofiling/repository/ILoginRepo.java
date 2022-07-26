package com.app.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.censusprofiling.entity.Login;

@Repository
public interface ILoginRepo extends JpaRepository<Login,String>{

}
