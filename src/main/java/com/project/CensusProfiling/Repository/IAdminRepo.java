package com.project.CensusProfiling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.AdminEntity;

@Repository
public interface IAdminRepo extends JpaRepository<AdminEntity,String>{

}
