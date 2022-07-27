package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.LoginDto;
import com.app.censusprofiling.dto.LoginRespDto;
import com.app.censusprofiling.entity.Login;
import com.app.censusprofiling.exception.EmailNotFoundException;
import com.app.censusprofiling.exception.LoginAlreadyExistsException;
import com.app.censusprofiling.exception.LoginInvalidCredentialsException;
import com.app.censusprofiling.exception.LoginNotFoundException;
import com.app.censusprofiling.repository.ILoginRepo;

@Service
public class LoginServiceImpl implements ILoginService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ILoginRepo iLoginRepo;

	@Override
	public List<Login> getAllLogins() {
		
		return iLoginRepo.findAll();
	}

	@Override
	public Optional<Login> getLogin(String id) throws LoginNotFoundException {
		Optional<Login> loginData = iLoginRepo.findById(id);
		if(!loginData.isEmpty()) {
			return iLoginRepo.findById(id);
		}
		else {
			LOGGER.error("Login Not Found in getLogin");
			throw new LoginNotFoundException("Login Not Found with id "+id);
		}
	}

	@Override
	public Login addLogin(Login login) throws LoginAlreadyExistsException {
		Optional<Login> loginData = iLoginRepo.findById(login.getEmail());
		if(loginData.isEmpty()) {
			return iLoginRepo.save(login);
		}
		else {
			LOGGER.error("Login already Found in addLogin");
			throw new LoginAlreadyExistsException("Login Already Exists with id "+ login.getEmail());
		}
	}

	@Override
	public Optional<Login> deleteLogin(String id) throws LoginNotFoundException {
		Optional<Login> loginData = iLoginRepo.findById(id);
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
	public Login updateLogin(String id, Login login) throws LoginNotFoundException {
		Optional<Login> loginData = iLoginRepo.findById(id);
		if(!loginData.isEmpty()) {
			login.setEmail(id);
			return iLoginRepo.save(login);
		}
		else {
			LOGGER.error("Login Not Found in updateLogin");
			throw new LoginNotFoundException("Login Not Found with id "+id);
		}
	}

	@Override
	public Login login(Login credentials) {
		// get login details from db
				Optional<Login> dbLoginCred = iLoginRepo.findById(credentials.getEmail());

				if (dbLoginCred.isPresent()) {
					// compare db password with user provided password
					// if password matching return credentials else throw exception
					Login login = dbLoginCred.get();
					if (login.getPassword().equals(credentials.getPassword())
							&& login.getRole().equals(credentials.getRole())) {
						login.setLoggedIn(true);
						return iLoginRepo.save(login);
						
					} else {
						throw new LoginInvalidCredentialsException("Invalid credentials!");
					}
				} else {
					// throw exception if given email not present in the db.
					throw new LoginInvalidCredentialsException("User not found with email: "+credentials.getEmail());
				}
	}

	@Override
	public LoginRespDto login(LoginDto loginDto) {
		Optional<Login> dbLoginOpt = iLoginRepo.findById(loginDto.getEmail());

		if (dbLoginOpt.isPresent()) {
			// compare db password with user provided password
			// if password matching return credentials else throw exception
			Login login = dbLoginOpt.get();
			if (login.getPassword().equals(loginDto.getPassword())
					&& login.getRole().equals(loginDto.getRole())) {
				
				// if credentials matches, set loggedIn flag as true and save
				login.setLoggedIn(true);
				Login updatedLogin = iLoginRepo.save(login);
				
				// convert Login to LoginRespDto Obj
				LoginRespDto resDto = new LoginRespDto();
				resDto.setEmail(login.getEmail());
				resDto.setRole(login.getRole());
				resDto.setLoggedIn(login.isLoggedIn());
				
				return resDto;
				
			} else {
				throw new LoginInvalidCredentialsException("Invalid credentials!");
			}
		} else {
			// throw exception if given email not present in the db.
			throw new LoginInvalidCredentialsException("User not found with email: "+loginDto.getEmail());
		}
	}

	@Override
	public LoginRespDto logout(String email) throws EmailNotFoundException {
		Optional<Login> dbLoginOpt = iLoginRepo.findById(email);
		if(dbLoginOpt.isPresent()) {
			// update isLoggedIn flag as false and save
			Login login = dbLoginOpt.get();
			
			// Update flag to false and save
			login.setLoggedIn(false);
			Login updatedLogin = iLoginRepo.save(login);
			
			// Convert Login obj to LoginRespDto
			LoginRespDto resDto = new LoginRespDto();
			
			resDto.setLoggedIn(false);
					
			// return LoginRespDto obj
			return resDto;
		} else {
			throw new EmailNotFoundException("User not found with email: "+email);
		}
		
	}
	
	

}
