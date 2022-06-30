package com.project.CensusProfiling.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.UserEntity;
import com.project.CensusProfiling.Exception.UserAlreadyExistsException;
import com.project.CensusProfiling.Exception.UserNotFoundException;

@Service
public interface IUserService {
	
	public List<UserEntity> getAllUsers();
	
	public Optional<UserEntity> getUser(int id) throws UserNotFoundException;
	
	public UserEntity addUser(UserEntity  userEntity) throws UserAlreadyExistsException;
	
	public Optional<UserEntity> deleteUser(int id) throws UserNotFoundException;
	
	public UserEntity updateUser(int id, UserEntity userEntity) throws UserNotFoundException;

	public Optional<UserEntity> findByApplicationId(int id) throws Exception;

	public List<UserEntity> findByApplicationStatus(String status) throws Exception;
	
}
