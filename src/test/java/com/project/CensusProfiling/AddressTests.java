package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.AddressEntity;
import com.project.CensusProfiling.Exception.AddressAlreadyExistsException;
import com.project.CensusProfiling.Exception.AddressNotFoundException;
import com.project.CensusProfiling.Services.IAddressService;

@ExtendWith(MockitoExtension.class)
public class AddressTests {

	@Mock
	IAddressService iAddressService;

	@Test
	void addAddressTest() throws AddressAlreadyExistsException {
		AddressEntity addressEntity = new AddressEntity(1,"1-30/2","local","hyd","telangana","123654");
		when(iAddressService.addAddress(addressEntity)).thenReturn(addressEntity);
		assertEquals(iAddressService.addAddress(addressEntity),addressEntity);
	}
	
	@Test
	void getAddressTest() throws AddressNotFoundException {
		AddressEntity addressEntity = new AddressEntity(1,"1-30/2","local","hyd","telangana","123654");
		Optional<AddressEntity> OAddressEntity = Optional.of(addressEntity);
		when(iAddressService.getAddress(1)).thenReturn(OAddressEntity);
		assertEquals(iAddressService.getAddress(1).get(),addressEntity);
	}
	
	@Test
	void updateAddressTest() throws AddressNotFoundException {
		AddressEntity addressEntity = new AddressEntity(1,"1-30/2","local","hyd","telangana","123654");
		when(iAddressService.updateAddress(1,addressEntity)).thenReturn(addressEntity);
		assertEquals(iAddressService.updateAddress(1,addressEntity),addressEntity);
	}
	
	@Test
	void deleteAddressTest() throws AddressNotFoundException {
		AddressEntity addressEntity = new AddressEntity(1,"1-30/2","local","hyd","telangana","123654");
		Optional<AddressEntity> OAddressEntity = Optional.of(addressEntity);
		when(iAddressService.deleteAddress(1)).thenReturn(OAddressEntity);
		assertEquals(iAddressService.deleteAddress(1).get(),addressEntity);
	}

}
