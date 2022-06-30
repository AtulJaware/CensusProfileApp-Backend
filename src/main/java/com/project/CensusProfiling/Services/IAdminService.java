package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.AdminEntity;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;

@Service
public interface IAdminService {
	
	public List<AdminEntity> getAllAdmins();
	
	public Optional<AdminEntity> getAdmin(String id) throws AdminNotFoundException;
	
	public AdminEntity addAdmin(AdminEntity  adminEntity) throws AdminAlreadyExistsException;
	
	public Optional<AdminEntity> deleteAdmin(String id) throws AdminNotFoundException;
	
	public AdminEntity updateAdmin(String id, AdminEntity adminEntity) throws AdminNotFoundException;
}
