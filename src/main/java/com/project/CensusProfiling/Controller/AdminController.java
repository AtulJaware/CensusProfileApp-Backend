package com.project.CensusProfiling.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.CensusProfiling.Entity.Admin;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.Services.IAdminService;
import com.project.CensusProfiling.dto.RegRespDto;
import com.project.CensusProfiling.dto.RegisterDto;

@RestController
public class AdminController {

	@Autowired
	private IAdminService iAdminService;
	

	@GetMapping("/admin")
	public List<Admin> getAllAdmins(){
		return iAdminService.getAllAdmins();
	}
	
	@GetMapping("/admin/{adminId}")
	public Optional<Admin> getAdmin(@PathVariable int adminId) throws AdminNotFoundException{
		return iAdminService.getAdmin(adminId);
	}
	
	@PostMapping("/admin")
	public Admin addAdmin(@Valid @RequestBody Admin  admin) throws AdminAlreadyExistsException{
		return iAdminService.addAdmin(admin);
	}
	
	@DeleteMapping("/admin/{adminId}")
	public Optional<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException{
		return iAdminService.deleteAdmin(adminId);
	}

	@PutMapping("/admin/{adminId}")
	public Admin updateAdmin(@PathVariable int adminId, @Valid @RequestBody Admin admin) throws AdminNotFoundException{
		return iAdminService.updateAdmin(adminId, admin);
	}
	
	// Register admin
		@PostMapping("/admin/register")
		ResponseEntity<RegRespDto> regAdmin(@Valid @RequestBody RegisterDto admin) throws AdminAlreadyExistsException {
			System.out.println();
			RegRespDto newAdmin = iAdminService.regAdmin(admin);
			return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		}
}
