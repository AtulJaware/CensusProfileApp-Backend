package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.LoginDto;
import com.app.censusprofiling.dto.LoginRespDto;
import com.app.censusprofiling.entity.Login;
import com.app.censusprofiling.exception.EmailNotFoundException;
import com.app.censusprofiling.exception.LoginAlreadyExistsException;
import com.app.censusprofiling.exception.LoginNotFoundException;

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
