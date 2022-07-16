package com.project.CensusProfiling.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.Application;
import com.project.CensusProfiling.Entity.User;
import com.project.CensusProfiling.Exception.ApplicationNotFoundException;
import com.project.CensusProfiling.Exception.UserAlreadyExistsException;
import com.project.CensusProfiling.Exception.UserNotFoundException;
import com.project.CensusProfiling.Repository.IApplicationRepo;
import com.project.CensusProfiling.Repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserRepo userRepo;
	
	@Override
	public List<User> getAllUsers() {
		LOGGER.info("inside getAllUsers");
		return userRepo.findAll();
	}
	

	@Override
	public Optional<User> getUser(int id) throws UserNotFoundException {
		
		LOGGER.info("inside getUser");
		Optional<User> userData = userRepo.findById(id);
		if(!userData.isEmpty()) {
			return userRepo.findById(id);
		}
		else {
			LOGGER.error("User Not Found in getUser");
			throw new UserNotFoundException("User Not Found with id "+id);
		}
	}

	@Override
	public User addUser(User user) throws UserAlreadyExistsException {
		LOGGER.info("inside addUser");
		Optional<User> userData = userRepo.findById(user.getId());
		if(userData.isEmpty()) {
			return userRepo.save(user);
		}
		else {
			LOGGER.error("User already Found in addUser");
			throw new UserAlreadyExistsException("User Already Exists with id "+user.getId());
		}
	}

	@Override
	public Optional<User> deleteUser(int id) throws UserNotFoundException {
		LOGGER.info("inside deleteUser");
		Optional<User> userData = userRepo.findById(id);
		if(!userData.isEmpty()) {
			userRepo.deleteById(id);
			return userData;
		}
		else {
			LOGGER.error("User Not Found in deleteUser");
			throw new UserNotFoundException("User Not Found with id "+id);
		}
	}

	@Override
	public User updateUser(int id, User user) throws UserNotFoundException {
		LOGGER.info("inside updateUser");
		Optional<User> userData = userRepo.findById(id);
		if(!userData.isEmpty()) {
			user.setId(id);
			return userRepo.save(user);
		}
		else {
			LOGGER.error("User Not Found in updateUser");
			throw new UserNotFoundException("User Not Found with id "+id);
		}
	}
	
	@Autowired IApplicationRepo iApplicationRepo;
	
	@Override
	public Optional<User> findByApplicationId(int id) throws Exception {
		
		try {
			Optional<Application> application = iApplicationRepo.findById(id);
			return userRepo.findById(application.get().getUser_id());
		}
		catch(Exception e) {
			throw new Exception("User not found with application id "+id);
		}
	}


	@Override
	public List<User> findByApplicationStatus(String status) throws Exception {
		List<User> userList = new ArrayList<>();
		try {
			List<Application> applications = iApplicationRepo.findByStatus(status);
			for(Application application:applications) {
				try {
					Optional<User> user = userRepo.findById(application.getUser_id());
					userList.add(user.get());
				}
				catch(Exception e) {
					
				}
			}
		}
		catch(Exception e){
			throw new Exception("no user found with status "+status);
		}
		return userList;
	}



}
