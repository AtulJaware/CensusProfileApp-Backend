package com.app.censusprofiling.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.censusprofiling.entity.Address;
import com.app.censusprofiling.exception.AddressAlreadyExistsException;
import com.app.censusprofiling.exception.AddressNotFoundException;
import com.app.censusprofiling.services.IAddressService;

@RestController
public class AddressController {
	
	@Autowired
	private IAddressService iAddressService;
	

	@GetMapping("/addresses")
	public List<Address> getAllAddresss(){
		return iAddressService.getAllAddresss();
	}
	
	@GetMapping("/address/{id}")
	public Optional<Address> getAddress(@PathVariable int id) throws AddressNotFoundException{
		return iAddressService.getAddress(id);
	}
	
	@PostMapping("/address/add")
	public Address addAddress(@Valid @RequestBody Address  address) throws AddressAlreadyExistsException{
		return iAddressService.addAddress(address);
	}
	
	@DeleteMapping("/address/delete/{id}")
	public Optional<Address> deleteAddress(@PathVariable int id) throws AddressNotFoundException{
		return iAddressService.deleteAddress(id);
	}

	@PutMapping("/address/update/{id}")
	public Address updateAddress(@PathVariable int id, @Valid @RequestBody Address address) throws AddressNotFoundException{
		return iAddressService.updateAddress(id, address);
	}


}
