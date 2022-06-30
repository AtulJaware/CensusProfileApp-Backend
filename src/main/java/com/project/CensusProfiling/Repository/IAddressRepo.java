package com.project.CensusProfiling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CensusProfiling.Entity.AddressEntity;


@Repository
public interface IAddressRepo extends JpaRepository<AddressEntity,Integer>{

}
