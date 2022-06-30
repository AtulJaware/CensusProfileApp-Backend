package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.LoginEntity;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;

@Service
public interface ILoginService {

	public List<LoginEntity> getAllLogins();
	
	public Optional<LoginEntity> getLogin(String id) throws LoginNotFoundException;
	
	public LoginEntity addLogin(LoginEntity  loginEntity) throws LoginAlreadyExistsException;
	
	public Optional<LoginEntity> deleteLogin(String id) throws LoginNotFoundException;
	
	public LoginEntity updateLogin(String id, LoginEntity loginEntity) throws LoginNotFoundException;
}
