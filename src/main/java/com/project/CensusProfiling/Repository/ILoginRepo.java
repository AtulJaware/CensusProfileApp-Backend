package com.project.CensusProfiling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.Login;

@Repository
public interface ILoginRepo extends JpaRepository<Login,String>{

}
