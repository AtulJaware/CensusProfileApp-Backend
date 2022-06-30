package com.project.CensusProfiling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.LoginEntity;

@Repository
public interface ILoginRepo extends JpaRepository<LoginEntity,String>{

}
