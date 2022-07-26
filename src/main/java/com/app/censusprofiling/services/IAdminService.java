package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.censusprofiling.dto.AdminRegRespDto;
import com.app.censusprofiling.dto.AdminRegisterDto;
import com.app.censusprofiling.entity.Admin;
import com.app.censusprofiling.exception.AdminAlreadyExistsException;
import com.app.censusprofiling.exception.AdminNotFoundException;

@Service
public interface IAdminService {
	
	public List<Admin> getAllAdmins();
	
	public Optional<Admin> getAdmin(int adminId) throws AdminNotFoundException;
	
	public Admin addAdmin(Admin  admin) throws AdminAlreadyExistsException;
	
	public Optional<Admin> deleteAdmin(int adminId) throws AdminNotFoundException;
	
	public Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException;
	
	AdminRegRespDto regAdmin(AdminRegisterDto admin) throws AdminAlreadyExistsException;

	Admin getAdminByEmail(String email) throws AdminNotFoundException;
}
