package com.project.CensusProfiling.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.CensusProfiling.Entity.MemberEntity;
import com.project.CensusProfiling.Entity.UserEntity;
import com.project.CensusProfiling.Exception.UserAlreadyExistsException;
import com.project.CensusProfiling.Exception.UserNotFoundException;
import com.project.CensusProfiling.Services.IMemberService;
import com.project.CensusProfiling.Services.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IMemberService iMemberService;
	
	@GetMapping("/user")
	public List<UserEntity> getAllUsers(){
		return iUserService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<UserEntity> getUser(@PathVariable int id) throws UserNotFoundException{
		return iUserService.getUser(id);
	}
	
	@GetMapping("/getMemberByFirstName/{firstName}")
	public List<MemberEntity> getByName(@PathVariable String firstName) throws UserNotFoundException{
		return iMemberService.findByFname(firstName);
	}
	
	@GetMapping("/getMemberByLastName/{LastName}")
	public List<MemberEntity> getUserByLname(@PathVariable String LastName) throws UserNotFoundException{
		return iMemberService.findByLname(LastName);
	}
	
	@GetMapping("/getMemberByDOB/{dob}")
	public List<MemberEntity> getUserByDOB(@PathVariable String dob) throws UserNotFoundException{
		return iMemberService.findByDob(LocalDate.parse(dob));
	}
	
	@GetMapping("/getUserByApplicationId/{id}") 
	public Optional<UserEntity> getUserByApplicationId(@PathVariable int id) throws Exception{
		return iUserService.findByApplicationId(id);
	}
	
	@GetMapping("/getUserByApplicationStatus/{status}")
	public List<UserEntity> getUserByApplicationStatus(@PathVariable String status) throws Exception{
		return iUserService.findByApplicationStatus(status);
	}
	
	@PostMapping("/user")
	public UserEntity addUser(@Valid @RequestBody UserEntity  userEntity) throws UserAlreadyExistsException{
		return iUserService.addUser(userEntity);
	}
	
	@DeleteMapping("/user/{id}")
	public Optional<UserEntity> deleteUser(@PathVariable int id) throws UserNotFoundException{
		return iUserService.deleteUser(id);
	}

	@PutMapping("/user/{id}")
	public UserEntity updateUser(@PathVariable int id, @Valid @RequestBody UserEntity userEntity) throws UserNotFoundException{
		return iUserService.updateUser(id, userEntity);
	}
}
