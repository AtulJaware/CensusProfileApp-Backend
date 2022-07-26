package com.app.censusprofiling.services;

import java.util.List;
import java.util.Optional;

import com.app.censusprofiling.entity.Application;
import com.app.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.app.censusprofiling.exception.ApplicationNotFoundException;

public interface IApplicationService {
	
	public List<Application> getAllApplications();
	
	public Optional<Application> getApplication(int id) throws ApplicationNotFoundException;
	
	public Application addApplication(Application  application) throws ApplicationAlreadyExistsException;
	
	public Optional<Application> deleteApplication(int id) throws ApplicationNotFoundException;
	
	public Application updateApplication(int id, Application application) throws ApplicationNotFoundException;

}
