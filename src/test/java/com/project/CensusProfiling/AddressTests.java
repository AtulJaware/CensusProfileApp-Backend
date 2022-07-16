package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.Address;
import com.project.CensusProfiling.Exception.AddressAlreadyExistsException;
import com.project.CensusProfiling.Exception.AddressNotFoundException;
import com.project.CensusProfiling.Services.IAddressService;

@ExtendWith(MockitoExtension.class)
public class AddressTests {

	@Mock
	IAddressService iAddressService;

	@Test
	void addAddressTest() throws AddressAlreadyExistsException {
		Address address = new Address(1,"1-30/2","local","hyd","telangana","123654");
		when(iAddressService.addAddress(address)).thenReturn(address);
		assertEquals(iAddressService.addAddress(address),address);
	}
	
	@Test
	void getAddressTest() throws AddressNotFoundException {
		Address address = new Address(1,"1-30/2","local","hyd","telangana","123654");
		Optional<Address> OAddressEntity = Optional.of(address);
		when(iAddressService.getAddress(1)).thenReturn(OAddressEntity);
		assertEquals(iAddressService.getAddress(1).get(),address);
	}
	
	@Test
	void updateAddressTest() throws AddressNotFoundException {
		Address address = new Address(1,"1-30/2","local","hyd","telangana","123654");
		when(iAddressService.updateAddress(1,address)).thenReturn(address);
		assertEquals(iAddressService.updateAddress(1,address),address);
	}
	
	@Test
	void deleteAddressTest() throws AddressNotFoundException {
		Address address = new Address(1,"1-30/2","local","hyd","telangana","123654");
		Optional<Address> OAddressEntity = Optional.of(address);
		when(iAddressService.deleteAddress(1)).thenReturn(OAddressEntity);
		assertEquals(iAddressService.deleteAddress(1).get(),address);
	}

}
