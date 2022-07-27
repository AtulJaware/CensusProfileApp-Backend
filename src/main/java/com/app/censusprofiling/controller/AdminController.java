package com.app.censusprofiling.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.censusprofiling.dto.AdminRegRespDto;
import com.app.censusprofiling.dto.AdminRegisterDto;
import com.app.censusprofiling.entity.Admin;
import com.app.censusprofiling.exception.AdminAlreadyExistsException;
import com.app.censusprofiling.exception.AdminNotFoundException;
import com.app.censusprofiling.services.IAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;
	

	@GetMapping("/admins")
	public List<Admin> getAllAdmins(){
		return iAdminService.getAllAdmins();
	}
	
	@GetMapping("/admin/email/{email}")
	ResponseEntity<Admin> getEmpByEmail(@PathVariable("email") String email) throws AdminNotFoundException {
		Admin admin = iAdminService.getAdminByEmail(email);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/admin/{adminId}")
	public Optional<Admin> getAdmin(@PathVariable int adminId) throws AdminNotFoundException{
		return iAdminService.getAdmin(adminId);
	}
	
	@PostMapping("/admin/add")
	public Admin addAdmin(@Valid @RequestBody Admin  admin) throws AdminAlreadyExistsException{
		return iAdminService.addAdmin(admin);
	}
	
	@DeleteMapping("/admin/delete/{adminId}")
	public Optional<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException{
		return iAdminService.deleteAdmin(adminId);
	}

	@PutMapping("/admin/update/{adminId}")
	public Admin updateAdmin(@PathVariable int adminId, @Valid @RequestBody Admin admin) throws AdminNotFoundException{
		return iAdminService.updateAdmin(adminId, admin);
	}
	
	// Register admin
		@PostMapping("/admin/register")
		ResponseEntity<AdminRegRespDto> regAdmin(@Valid @RequestBody AdminRegisterDto admin) throws AdminAlreadyExistsException {
			System.out.println();
			AdminRegRespDto newAdmin = iAdminService.regAdmin(admin);
			return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		}
}
