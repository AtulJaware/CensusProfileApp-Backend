package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.Login;
import com.project.CensusProfiling.Exception.EmailNotFoundException;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;
import com.project.CensusProfiling.dto.LoginDto;
import com.project.CensusProfiling.dto.LoginRespDto;

@Service
public interface ILoginService {

	public List<Login> getAllLogins();
	
	public Optional<Login> getLogin(String id) throws LoginNotFoundException;
	
	public Login addLogin(Login  login) throws LoginAlreadyExistsException;
	
	public Optional<Login> deleteLogin(String id) throws LoginNotFoundException;
	
	public Login updateLogin(String id, Login login) throws LoginNotFoundException;
	
	Login login(Login credentials);

	LoginRespDto login(LoginDto loginDto);

	LoginRespDto logout(String email) throws EmailNotFoundException;
}
