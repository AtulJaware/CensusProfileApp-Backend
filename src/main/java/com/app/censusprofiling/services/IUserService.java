package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.UserRegRespDto;
import com.app.censusprofiling.dto.UserRegisterDto;
import com.app.censusprofiling.entity.User;
import com.app.censusprofiling.exception.ApplicationNotFoundException;
import com.app.censusprofiling.exception.LoginNotFoundException;
import com.app.censusprofiling.exception.UserAlreadyExistsException;
import com.app.censusprofiling.exception.UserNotFoundException;

@Service
public interface IUserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUser(int id) throws UserNotFoundException;
	
	public User addUser(User  user) throws UserAlreadyExistsException;
	
	public Optional<User> deleteUser(int id) throws UserNotFoundException;
	
	public User updateUser(int id, User user) throws UserNotFoundException;

	public Optional<User> findByApplicationId(int id) throws ApplicationNotFoundException;

	public List<User> findByApplicationStatus(String status) throws ApplicationNotFoundException;

	User getUserByEmail(String email) throws LoginNotFoundException;
	
	UserRegRespDto regUser(UserRegisterDto regDto) throws UserAlreadyExistsException;
	
}
