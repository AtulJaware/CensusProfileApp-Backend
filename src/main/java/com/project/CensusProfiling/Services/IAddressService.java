package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.Address;
import com.project.CensusProfiling.Exception.AddressAlreadyExistsException;
import com.project.CensusProfiling.Exception.AddressNotFoundException;

@Service
public interface IAddressService {
	
	public List<Address> getAllAddresss();
	
	public Optional<Address> getAddress(int id) throws AddressNotFoundException;
	
	public Address addAddress(Address  address) throws AddressAlreadyExistsException;
	
	public Optional<Address> deleteAddress(int id) throws AddressNotFoundException;
	
	public Address updateAddress(int id, Address address) throws AddressNotFoundException;
}
