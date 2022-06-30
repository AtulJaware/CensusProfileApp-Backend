package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.AddressEntity;
import com.project.CensusProfiling.Exception.AddressAlreadyExistsException;
import com.project.CensusProfiling.Exception.AddressNotFoundException;
import com.project.CensusProfiling.Repository.IAddressRepo;

@Service
public class AddressServiceImpl implements IAddressService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAddressRepo iAddressRepo;
	
	@Override
	public List<AddressEntity> getAllAddresss() {
		// TODO Auto-generated method stub
		return iAddressRepo.findAll();
	}

	@Override
	public Optional<AddressEntity> getAddress(int id) throws AddressNotFoundException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(id);
		if(!addressData.isEmpty()) {
			return iAddressRepo.findById(id);
		}
		else {
			LOGGER.error("Address Not Found in getAddress");
			throw new AddressNotFoundException("Address Not Found with id "+id);
		}
	}

	@Override
	public AddressEntity addAddress(AddressEntity addressEntity) throws AddressAlreadyExistsException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(addressEntity.getId());
		if(addressData.isEmpty()) {
			return iAddressRepo.save(addressEntity);
		}
		else {
			LOGGER.error("Address already Found in addAddress");
			throw new AddressAlreadyExistsException("Address already exists with id "+addressEntity.getId());
		}
	}

	@Override
	public Optional<AddressEntity> deleteAddress(int id) throws AddressNotFoundException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(id);
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
	public AddressEntity updateAddress(int id, AddressEntity addressEntity) throws AddressNotFoundException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(id);
		if(!addressData.isEmpty()) {
			addressEntity.setId(id);
			return iAddressRepo.save(addressEntity);
		}
		else {
			LOGGER.error("Address Not Found in updateAddress");
			throw new AddressNotFoundException("Address Not Found with id "+id);
		}
	}

}
