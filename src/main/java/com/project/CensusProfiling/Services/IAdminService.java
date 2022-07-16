package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.Admin;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.dto.RegRespDto;
import com.project.CensusProfiling.dto.RegisterDto;

@Service
public interface IAdminService {
	
	public List<Admin> getAllAdmins();
	
	public Optional<Admin> getAdmin(int adminId) throws AdminNotFoundException;
	
	public Admin addAdmin(Admin  admin) throws AdminAlreadyExistsException;
	
	public Optional<Admin> deleteAdmin(int adminId) throws AdminNotFoundException;
	
	public Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException;
	
	RegRespDto regAdmin(RegisterDto admin) throws AdminAlreadyExistsException;
}
