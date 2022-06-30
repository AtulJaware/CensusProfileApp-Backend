package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CensusProfiling.Entity.ApplicationEntity;
import com.project.CensusProfiling.Exception.ApplicationAlreadyExistsException;
import com.project.CensusProfiling.Exception.ApplicationNotFoundException;
import com.project.CensusProfiling.Repository.IApplicationRepo;

@Service
public class ApplicationServiceImpl implements IApplicationService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IApplicationRepo iApplicationRepo;
	
	@Override
	public List<ApplicationEntity> getAllApplications() {
		// TODO Auto-generated method stub
		return iApplicationRepo.findAll();
	}

	@Override
	public Optional<ApplicationEntity> getApplication(int id) throws ApplicationNotFoundException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(id);
		if(!applicationData.isEmpty()) {
			return iApplicationRepo.findById(id);
		}
		else {
			LOGGER.error("Application Not Found in getApplication");
			throw new ApplicationNotFoundException("Application Not Found with id "+id);
		}
	}

	@Override
	public ApplicationEntity addApplication(ApplicationEntity applicationEntity) throws ApplicationAlreadyExistsException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(applicationEntity.getId());
		if(applicationData.isEmpty()) {
			return iApplicationRepo.save(applicationEntity);
		}
		else {
			LOGGER.error("Application already Found in addApplication");
			throw new ApplicationAlreadyExistsException("Application already exists with id "+applicationEntity.getId());
		}
	}

	@Override
	public Optional<ApplicationEntity> deleteApplication(int id) throws ApplicationNotFoundException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(id);
		if(!applicationData.isEmpty()) {
			iApplicationRepo.deleteById(id);
			return applicationData;
		}
		else {
			LOGGER.error("Application Not Found in deleteApplication");
			throw new ApplicationNotFoundException("Application Not Found with id "+id);
		}
	}

	@Override
	public ApplicationEntity updateApplication(int id, ApplicationEntity applicationEntity) throws ApplicationNotFoundException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(id);
		if(!applicationData.isEmpty()) {
			applicationEntity.setId(id);
			return iApplicationRepo.save(applicationEntity);
		}
		else {
			LOGGER.error("Application Not Found in updateApplication");
			throw new ApplicationNotFoundException("Application Not Found with id "+id);
		}
	}

}
