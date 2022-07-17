package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.Admin;
import com.project.CensusProfiling.Entity.Login;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.Repository.IAdminRepo;
import com.project.CensusProfiling.Repository.ILoginRepo;
import com.project.CensusProfiling.dto.AdminRegRespDto;
import com.project.CensusProfiling.dto.AdminRegisterDto;

@Service
public class AdminServiceImpl implements IAdminService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAdminRepo iAdminRepo;
	
	@Autowired
	ILoginRepo loginRepo;
	
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return iAdminRepo.findAll();
	}

	@Override
	public Optional<Admin> getAdmin(int id) throws AdminNotFoundException {
		Optional<Admin> adminData = iAdminRepo.findById(id);
		if(!adminData.isEmpty()) {
			return iAdminRepo.findById(id);
		}
		else {
			LOGGER.error("Admin Not Found in getAddress");
			throw new AdminNotFoundException("Admin Not Found with id "+id);
		}
	}

	@Override
	public Admin addAdmin(Admin admin) throws AdminAlreadyExistsException {
		Optional<Admin> adminData = iAdminRepo.findById(admin.getAdminId());
		if(adminData.isEmpty()) {
			return iAdminRepo.save(admin);
		}
		else {
			LOGGER.error("Admin already Found in addAdmin");
			throw new AdminAlreadyExistsException("Admin already exists with id "+admin.getAdminId());
		}
	}

	@Override
	public Optional<Admin> deleteAdmin(int id) throws AdminNotFoundException {
		Optional<Admin> adminData = iAdminRepo.findById(id);
		if(!adminData.isEmpty()) {
			iAdminRepo.deleteById(id);
			return adminData;
		}
		else {
			LOGGER.error("Admin Not Found in deleteAdmin");
			throw new AdminNotFoundException("Admin Not Found with id "+id);
		}
	}

	@Override
	public Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException {
		Optional<Admin> adminData = iAdminRepo.findById(adminId);
		if(adminData.isPresent()) {
			return iAdminRepo.save(admin);
		}
		else {
			LOGGER.error("Admin Not Found in updateAdmin");
			throw new AdminNotFoundException("Admin Not Found with email "+ adminId);
		}
	}

	@Override
	public AdminRegRespDto regAdmin(AdminRegisterDto regDto) throws AdminAlreadyExistsException {
		Optional<Login> loginOpt = loginRepo.findById(regDto.getEmail());
		if(loginOpt.isPresent()) {
			throw new AdminAlreadyExistsException("Given email address "+regDto.getEmail()+" present already! Choose different one");
		}
		
		// Convert RegisterDto to Admin obj
		// Create admin obj
		Admin admin = new Admin();
		
		// Update admin obj details
		admin.setAdminId(regDto.getAdminId());
		admin.setName(regDto.getName());
		admin.setContact(regDto.getContact());
		
		Login login = new Login();
		login.setEmail(regDto.getEmail());
		login.setPassword(regDto.getPassword());
		login.setRole(regDto.getRole());
		login.setLoggedIn(false);
		
		admin.setLogin(login);
		
		// Save admin obj in db
		Admin newAdmin = iAdminRepo.save(admin);
		
		// convert admin obj to AdminRegRespDto obj
		
		AdminRegRespDto resDto = new AdminRegRespDto();
		resDto.setAdminId(newAdmin.getAdminId());
		resDto.setName(newAdmin.getName());
		resDto.setContact(newAdmin.getContact());
		resDto.setEmail(newAdmin.getLogin().getEmail());
		resDto.setRole(newAdmin.getLogin().getRole());
		resDto.setLoggedIn(newAdmin.getLogin().isLoggedIn());
		
		return resDto;
		
	}

}