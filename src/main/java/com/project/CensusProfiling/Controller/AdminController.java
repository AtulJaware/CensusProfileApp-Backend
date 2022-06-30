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

import com.project.CensusProfiling.Entity.AdminEntity;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.Services.IAdminService;

@RestController
public class AdminController {

	@Autowired
	private IAdminService iAdminService;
	

	@GetMapping("/admin")
	public List<AdminEntity> getAllAdmins(){
		return iAdminService.getAllAdmins();
	}
	
	@GetMapping("/admin/{email}")
	public Optional<AdminEntity> getAdmin(@PathVariable String email) throws AdminNotFoundException{
		return iAdminService.getAdmin(email);
	}
	
	@PostMapping("/admin")
	public AdminEntity addAdmin(@Valid @RequestBody AdminEntity  adminEntity) throws AdminAlreadyExistsException{
		return iAdminService.addAdmin(adminEntity);
	}
	
	@DeleteMapping("/admin/{email}")
	public Optional<AdminEntity> deleteAdmin(@PathVariable String email) throws AdminNotFoundException{
		return iAdminService.deleteAdmin(email);
	}

	@PutMapping("/admin/{email}")
	public AdminEntity updateAdmin(@PathVariable String email, @Valid @RequestBody AdminEntity adminEntity) throws AdminNotFoundException{
		return iAdminService.updateAdmin(email, adminEntity);
	}
}
