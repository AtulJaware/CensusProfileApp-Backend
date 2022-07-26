package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.censusprofiling.entity.Address;
import com.app.censusprofiling.exception.AddressAlreadyExistsException;
import com.app.censusprofiling.exception.AddressNotFoundException;
import com.app.censusprofiling.repository.IAddressRepo;

@Service
public class AddressServiceImpl implements IAddressService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAddressRepo iAddressRepo;
	
	@Override
	public List<Address> getAllAddresss() {
		// TODO Auto-generated method stub
		return iAddressRepo.findAll();
	}

	@Override
	public Optional<Address> getAddress(int id) throws AddressNotFoundException {
		Optional<Address> addressData = iAddressRepo.findById(id);
		if(!addressData.isEmpty()) {
			return iAddressRepo.findById(id);
		}
		else {
			LOGGER.error("Address Not Found in getAddress");
			throw new AddressNotFoundException("Address Not Found with id "+id);
		}
	}

	@Override
	public Address addAddress(Address address) throws AddressAlreadyExistsException {
		Optional<Address> addressData = iAddressRepo.findById(address.getId());
		if(addressData.isEmpty()) {
			return iAddressRepo.save(address);
		}
		else {
			LOGGER.error("Address already Found in addAddress");
			throw new AddressAlreadyExistsException("Address already exists with id "+address.getId());
		}
	}

	@Override
	public Optional<Address> deleteAddress(int id) throws AddressNotFoundException {
		Optional<Address> addressData = iAddressRepo.findById(id);
		if(!addressData.isEmpty()) {
			iAddressRepo.deleteById(id);
			return addressData;
		}
		else {
			LOGGER.error("Address Not Found in deleteAddress");
			throw new AddressNotFoundException("Address Not Found with id "+id);
		}
	}

	@Override
	public Address updateAddress(int id, Address address) throws AddressNotFoundException {
		Optional<Address> addressData = iAddressRepo.findById(id);
		if(!addressData.isEmpty()) {
			address.setId(id);
			return iAddressRepo.save(address);
		}
		else {
			LOGGER.error("Address Not Found in updateAddress");
			throw new AddressNotFoundException("Address Not Found with id "+id);
		}
	}

}
