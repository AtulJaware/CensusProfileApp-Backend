package com.app.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.censusprofiling.entity.Address;


@Repository
public interface IAddressRepo extends JpaRepository<Address,Integer>{

}
