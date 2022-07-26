package com.app.censusprofiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.censusprofiling.entity.Address;
import com.app.censusprofiling.exception.AddressAlreadyExistsException;
import com.app.censusprofiling.exception.AddressNotFoundException;
import com.app.censusprofiling.services.IAddressService;

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
