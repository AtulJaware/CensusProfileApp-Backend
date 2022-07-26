package com.app.censusprofiling.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.UserRegRespDto;
import com.app.censusprofiling.dto.UserRegisterDto;
import com.app.censusprofiling.entity.Application;
import com.app.censusprofiling.entity.Login;
import com.app.censusprofiling.entity.User;
import com.app.censusprofiling.exception.UserAlreadyExistsException;
import com.app.censusprofiling.exception.UserNotFoundException;
import com.app.censusprofiling.repository.IApplicationRepo;
import com.app.censusprofiling.repository.ILoginRepo;
import com.app.censusprofiling.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	ILoginRepo loginRepo;
	
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
		Optional<User> userData = userRepo.findById(user.getUserId());
		if(userData.isEmpty()) {
			return userRepo.save(user);
		}
		else {
			LOGGER.error("User already Found in addUser");
			throw new UserAlreadyExistsException("User Already Exists with id "+user.getUserId());
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
			user.setUserId(id);
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

	@Override
	public UserRegRespDto regUser(UserRegisterDto regDto) throws UserAlreadyExistsException {
		Optional<Login> loginOpt = loginRepo.findById(regDto.getEmail());
		if(loginOpt.isPresent()) {
			throw new UserAlreadyExistsException("Given email address "+regDto.getEmail()+" present already! Choose different one");
		}
		
		// Convert RegisterDto to User obj
		// Create user obj
		User user = new User();
		
		// Update user obj details
		user.setUserId(regDto.getUserId());
		user.setFirstName(regDto.getFirstName());
		user.setLastName(regDto.getLastName());
		user.setDOB(regDto.getDOB());
		user.setContactNo(regDto.getContactNo());
		
		Login login = new Login();
		login.setEmail(regDto.getEmail());
		login.setPassword(regDto.getPassword());
		login.setRole(regDto.getRole());
		login.setLoggedIn(false);
		
		user.setLogin(login);
		
		Application application = new Application();
        application.setId(regDto.getId());
        application.setStatus(regDto.getStatus());
        application.setUser_id(regDto.getUserId());
        user.setApplication_entity(application);
        
		// Save user obj in db
		User newUser = userRepo.save(user);
		
		// convert User obj to UserRegRespDto obj
		
		UserRegRespDto resDto = new UserRegRespDto();
		resDto.setUserId(newUser.getUserId());
		resDto.setFirstName(newUser.getFirstName());
		resDto.setLastName(newUser.getLastName());
		resDto.setContactNo(newUser.getContactNo());
		resDto.setDOB(newUser.getDOB());
		resDto.setEmail(newUser.getLogin().getEmail());
		resDto.setRole(newUser.getLogin().getRole());
		resDto.setLoggedIn(newUser.getLogin().isLoggedIn());
		resDto.setId(newUser.getApplication_entity().getId());
        resDto.setStatus(newUser.getApplication_entity().getStatus());
        resDto.setUser_id(newUser.getUserId());
        
		return resDto;
		
	}


	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		
		return userRepo.getUserByEmail(email);
	}

}