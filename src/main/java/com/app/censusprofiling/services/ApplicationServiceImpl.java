package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.censusprofiling.entity.Application;
import com.app.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.app.censusprofiling.exception.ApplicationNotFoundException;
import com.app.censusprofiling.repository.IApplicationRepo;

@Service
public class ApplicationServiceImpl implements IApplicationService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IApplicationRepo iApplicationRepo;
	
	@Override
	public List<Application> getAllApplications() {
		// TODO Auto-generated method stub
		return iApplicationRepo.findAll();
	}

	@Override
	public Optional<Application> getApplication(int id) throws ApplicationNotFoundException {
		Optional<Application> applicationData = iApplicationRepo.findById(id);
		if(!applicationData.isEmpty()) {
			return iApplicationRepo.findById(id);
		}
		else {
			LOGGER.error("Application Not Found in getApplication");
			throw new ApplicationNotFoundException("Application Not Found with id "+id);
		}
	}

	@Override
	public Application addApplication(Application application) throws ApplicationAlreadyExistsException {
		Optional<Application> applicationData = iApplicationRepo.findById(application.getId());
		if(applicationData.isEmpty()) {
			return iApplicationRepo.save(application);
		}
		else {
			LOGGER.error("Application already Found in addApplication");
			throw new ApplicationAlreadyExistsException("Application already exists with id "+application.getId());
		}
	}

	@Override
	public Optional<Application> deleteApplication(int id) throws ApplicationNotFoundException {
		Optional<Application> applicationData = iApplicationRepo.findById(id);
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
	public Application updateApplication(int id, Application application) throws ApplicationNotFoundException {
		Optional<Application> applicationData = iApplicationRepo.findById(id);
		if(!applicationData.isEmpty()) {
			application.setId(id);
			return iApplicationRepo.save(application);
		}
		else {
			LOGGER.error("Application Not Found in updateApplication");
			throw new ApplicationNotFoundException("Application Not Found with id "+id);
		}
	}

}
