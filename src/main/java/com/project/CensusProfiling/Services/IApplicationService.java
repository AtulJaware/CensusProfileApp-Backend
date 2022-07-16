package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import com.project.CensusProfiling.Entity.Application;
import com.project.CensusProfiling.Exception.ApplicationAlreadyExistsException;
import com.project.CensusProfiling.Exception.ApplicationNotFoundException;

public interface IApplicationService {
	
	public List<Application> getAllApplications();
	
	public Optional<Application> getApplication(int id) throws ApplicationNotFoundException;
	
	public Application addApplication(Application  application) throws ApplicationAlreadyExistsException;
	
	public Optional<Application> deleteApplication(int id) throws ApplicationNotFoundException;
	
	public Application updateApplication(int id, Application application) throws ApplicationNotFoundException;

}
