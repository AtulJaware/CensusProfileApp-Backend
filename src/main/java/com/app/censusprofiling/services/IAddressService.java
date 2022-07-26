package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.censusprofiling.entity.Address;
import com.app.censusprofiling.exception.AddressAlreadyExistsException;
import com.app.censusprofiling.exception.AddressNotFoundException;

@Service
public interface IAddressService {
	
	public List<Address> getAllAddresss();
	
	public Optional<Address> getAddress(int id) throws AddressNotFoundException;
	
	public Address addAddress(Address  address) throws AddressAlreadyExistsException;
	
	public Optional<Address> deleteAddress(int id) throws AddressNotFoundException;
	
	public Address updateAddress(int id, Address address) throws AddressNotFoundException;
}
