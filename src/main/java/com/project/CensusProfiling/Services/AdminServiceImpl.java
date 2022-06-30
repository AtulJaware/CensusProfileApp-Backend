package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.AdminEntity;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.Repository.IAdminRepo;

@Service
public class AdminServiceImpl implements IAdminService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAdminRepo iAdminRepo;
	
	@Override
	public List<AdminEntity> getAllAdmins() {
		// TODO Auto-generated method stub
		return iAdminRepo.findAll();
	}

	@Override
	public Optional<AdminEntity> getAdmin(String id) throws AdminNotFoundException {
		Optional<AdminEntity> adminData = iAdminRepo.findById(id);
		if(!adminData.isEmpty()) {
			return iAdminRepo.findById(id);
		}
		else {
			LOGGER.error("Admin Not Found in getAddress");
			throw new AdminNotFoundException("Admin Not Found with id "+id);
		}
	}

	@Override
	public AdminEntity addAdmin(AdminEntity adminEntity) throws AdminAlreadyExistsException {
		Optional<AdminEntity> adminData = iAdminRepo.findById(adminEntity.getEmail());
		if(adminData.isEmpty()) {
			return iAdminRepo.save(adminEntity);
		}
		else {
			LOGGER.error("Admin already Found in addAdmin");
			throw new AdminAlreadyExistsException("Admin already exists with id "+adminEntity.getEmail());
		}
	}

	@Override
	public Optional<AdminEntity> deleteAdmin(String id) throws AdminNotFoundException {
		Optional<AdminEntity> adminData = iAdminRepo.findById(id);
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
	public AdminEntity updateAdmin(String id, AdminEntity adminEntity) throws AdminNotFoundException {
		Optional<AdminEntity> adminData = iAdminRepo.findById(id);
		if(!adminData.isEmpty()) {
			adminEntity.setEmail(id);
			return iAdminRepo.save(adminEntity);
		}
		else {
			LOGGER.error("Admin Not Found in updateAdmin");
			throw new AdminNotFoundException("Admin Not Found with id "+id);
		}
	}


}
