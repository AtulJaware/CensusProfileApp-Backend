package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.LoginEntity;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;
import com.project.CensusProfiling.Repository.ILoginRepo;

@Service
public class LoginServiceImpl implements ILoginService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ILoginRepo iLoginRepo;

	@Override
	public List<LoginEntity> getAllLogins() {
		// TODO Auto-generated method stub
		return iLoginRepo.findAll();
	}

	@Override
	public Optional<LoginEntity> getLogin(String id) throws LoginNotFoundException {
		Optional<LoginEntity> loginData = iLoginRepo.findById(id);
		if(!loginData.isEmpty()) {
			return iLoginRepo.findById(id);
		}
		else {
			LOGGER.error("Login Not Found in getLogin");
			throw new LoginNotFoundException("Login Not Found with id "+id);
		}
	}

	@Override
	public LoginEntity addLogin(LoginEntity loginEntity) throws LoginAlreadyExistsException {
		Optional<LoginEntity> loginData = iLoginRepo.findById(loginEntity.getEmail());
		if(loginData.isEmpty()) {
			return iLoginRepo.save(loginEntity);
		}
		else {
			LOGGER.error("Login already Found in addLogin");
			throw new LoginAlreadyExistsException("Login Already Exists with id "+ loginEntity.getEmail());
		}
	}

	@Override
	public Optional<LoginEntity> deleteLogin(String id) throws LoginNotFoundException {
		Optional<LoginEntity> loginData = iLoginRepo.findById(id);
		if(!loginData.isEmpty()) {
			iLoginRepo.deleteById(id);
			return loginData;
		}
		else {
			LOGGER.error("Login Not Found in deleteLogin");
			throw new LoginNotFoundException("Login Not Found with id "+id);
		}
	}

	@Override
	public LoginEntity updateLogin(String id, LoginEntity loginEntity) throws LoginNotFoundException {
		Optional<LoginEntity> loginData = iLoginRepo.findById(id);
		if(!loginData.isEmpty()) {
			loginEntity.setEmail(id);
			return iLoginRepo.save(loginEntity);
		}
		else {
			LOGGER.error("Login Not Found in updateLogin");
			throw new LoginNotFoundException("Login Not Found with id "+id);
		}
	}
	
	

}
