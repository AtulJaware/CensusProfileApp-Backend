package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.User;
import com.project.CensusProfiling.Exception.UserAlreadyExistsException;
import com.project.CensusProfiling.Exception.UserNotFoundException;

@Service
public interface IUserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUser(int id) throws UserNotFoundException;
	
	public User addUser(User  user) throws UserAlreadyExistsException;
	
	public Optional<User> deleteUser(int id) throws UserNotFoundException;
	
	public User updateUser(int id, User user) throws UserNotFoundException;

	public Optional<User> findByApplicationId(int id) throws Exception;

	public List<User> findByApplicationStatus(String status) throws Exception;
	
}
