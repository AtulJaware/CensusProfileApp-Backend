package com.project.CensusProfiling.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.CensusProfiling.Entity.Login;
import com.project.CensusProfiling.Exception.EmailNotFoundException;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;
import com.project.CensusProfiling.Services.ILoginService;
import com.project.CensusProfiling.dto.LoginDto;
import com.project.CensusProfiling.dto.LoginRespDto;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService iLoginService;
	

	@GetMapping("/login")
	public List<Login> getAllLogins(){
		return iLoginService.getAllLogins();
	}
	
	@GetMapping("/login/{email}")
	public Optional<Login> getLogin(@PathVariable String email) throws LoginNotFoundException{
		return iLoginService.getLogin(email);
	}
	
	@DeleteMapping("/login/{email}")
	public Optional<Login> deleteLogin(@PathVariable String email) throws LoginNotFoundException{
		return iLoginService.deleteLogin(email);
	}

	@PutMapping("/login/{email}")
	public Login updateLogin(@PathVariable String email, @Valid @RequestBody Login login) throws LoginNotFoundException{
		return iLoginService.updateLogin(email, login);
	}
	
	@PostMapping("/login")
	ResponseEntity<Login> login(@Valid @RequestBody Login credentials) throws LoginAlreadyExistsException{
		Login login= iLoginService.login(credentials);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}

	@PostMapping("/login/dto")
	ResponseEntity<LoginRespDto> login(@RequestBody LoginDto loginDto) {
		LoginRespDto login= iLoginService.login(loginDto);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PatchMapping("/logout")
	ResponseEntity<LoginRespDto> logout(@RequestBody String email) throws EmailNotFoundException {
		LoginRespDto resp = iLoginService.logout(email);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	

}
