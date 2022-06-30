package com.project.CensusProfiling.Controller;

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

import com.project.CensusProfiling.Entity.AddressEntity;
import com.project.CensusProfiling.Exception.AddressAlreadyExistsException;
import com.project.CensusProfiling.Exception.AddressNotFoundException;
import com.project.CensusProfiling.Services.IAddressService;

@RestController
public class AddressController {
	
	@Autowired
	private IAddressService iAddressService;
	

	@GetMapping("/address")
	public List<AddressEntity> getAllAddresss(){
		return iAddressService.getAllAddresss();
	}
	
	@GetMapping("/address/{id}")
	public Optional<AddressEntity> getAddress(@PathVariable int id) throws AddressNotFoundException{
		return iAddressService.getAddress(id);
	}
	
	@PostMapping("/address")
	public AddressEntity addAddress(@Valid @RequestBody AddressEntity  addressEntity) throws AddressAlreadyExistsException{
		return iAddressService.addAddress(addressEntity);
	}
	
	@DeleteMapping("/address/{id}")
	public Optional<AddressEntity> deleteAddress(@PathVariable int id) throws AddressNotFoundException{
		return iAddressService.deleteAddress(id);
	}

	@PutMapping("/address/{id}")
	public AddressEntity updateAddress(@PathVariable int id, @Valid @RequestBody AddressEntity addressEntity) throws AddressNotFoundException{
		return iAddressService.updateAddress(id, addressEntity);
	}


}
