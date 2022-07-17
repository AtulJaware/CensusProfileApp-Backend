package com.project.CensusProfiling.Controller;

import java.time.LocalDate;
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

import com.project.CensusProfiling.Entity.Member;
import com.project.CensusProfiling.Entity.User;
import com.project.CensusProfiling.Exception.UserAlreadyExistsException;
import com.project.CensusProfiling.Exception.UserNotFoundException;
import com.project.CensusProfiling.Services.IMemberService;
import com.project.CensusProfiling.Services.IUserService;
import com.project.CensusProfiling.dto.UserRegRespDto;
import com.project.CensusProfiling.dto.UserRegisterDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IMemberService iMemberService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return iUserService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return iUserService.getUser(id);
	}
	
	@GetMapping("/member/firstName/{firstName}")
	public List<Member> getByName(@PathVariable String firstName) throws UserNotFoundException{
		return iMemberService.findByFname(firstName);
	}
	
	@GetMapping("/member/lastName/{LastName}")
	public List<Member> getUserByLname(@PathVariable String LastName) throws UserNotFoundException{
		return iMemberService.findByLname(LastName);
	}
	
	@GetMapping("/member/DOB/{dob}")
	public List<Member> getUserByDOB(@PathVariable String dob) throws UserNotFoundException{
		return iMemberService.findByDob(LocalDate.parse(dob));
	}
	
	@GetMapping("/user/applicationId/{id}") 
	public Optional<User> getUserByApplicationId(@PathVariable int id) throws Exception{
		return iUserService.findByApplicationId(id);
	}
	
	@GetMapping("/user/applicationStatus/{status}")
	public List<User> getUserByApplicationStatus(@PathVariable String status) throws Exception{
		return iUserService.findByApplicationStatus(status);
	}
	
	@PostMapping("/user/add")
	public User addUser(@Valid @RequestBody User  user) throws UserAlreadyExistsException{
		return iUserService.addUser(user);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public Optional<User> deleteUser(@PathVariable int id) throws UserNotFoundException{
		return iUserService.deleteUser(id);
	}

	@PutMapping("/user/update/{id}")
	public User updateUser(@PathVariable int id, @Valid @RequestBody User user) throws UserNotFoundException{
		return iUserService.updateUser(id, user);
	}
	
	// Register user
	@PostMapping("/user/register")
	ResponseEntity<UserRegRespDto> regUser(@Valid @RequestBody UserRegisterDto user) throws UserAlreadyExistsException {
	System.out.println();
	UserRegRespDto newUser = iUserService.regUser(user);
	return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		}
}
