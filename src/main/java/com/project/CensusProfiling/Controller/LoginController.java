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

import com.project.CensusProfiling.Entity.LoginEntity;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;
import com.project.CensusProfiling.Services.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService iLoginService;
	

	@GetMapping("/login")
	public List<LoginEntity> getAllLogins(){
		return iLoginService.getAllLogins();
	}
	
	@GetMapping("/login/{email}")
	public Optional<LoginEntity> getLogin(@PathVariable String email) throws LoginNotFoundException{
		return iLoginService.getLogin(email);
	}
	
	@PostMapping("/login")
	public LoginEntity addLogin(@Valid @RequestBody LoginEntity  loginEntity) throws LoginAlreadyExistsException{
		return iLoginService.addLogin(loginEntity);
	}
	
	@DeleteMapping("/login/{email}")
	public Optional<LoginEntity> deleteLogin(@PathVariable String email) throws LoginNotFoundException{
		return iLoginService.deleteLogin(email);
	}

	@PutMapping("/login/{email}")
	public LoginEntity updateLogin(@PathVariable String email, @Valid @RequestBody LoginEntity loginEntity) throws LoginNotFoundException{
		return iLoginService.updateLogin(email, loginEntity);
	}

	
	

}
