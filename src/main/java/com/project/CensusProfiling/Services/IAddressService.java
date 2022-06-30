package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.AddressEntity;
import com.project.CensusProfiling.Exception.AddressAlreadyExistsException;
import com.project.CensusProfiling.Exception.AddressNotFoundException;

@Service
public interface IAddressService {
	
	public List<AddressEntity> getAllAddresss();
	
	public Optional<AddressEntity> getAddress(int id) throws AddressNotFoundException;
	
	public AddressEntity addAddress(AddressEntity  addressEntity) throws AddressAlreadyExistsException;
	
	public Optional<AddressEntity> deleteAddress(int id) throws AddressNotFoundException;
	
	public AddressEntity updateAddress(int id, AddressEntity addressEntity) throws AddressNotFoundException;
}
