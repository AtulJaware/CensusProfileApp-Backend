package com.project.CensusProfiling.Services;

import java.util.List;
import java.util.Optional;

import com.project.CensusProfiling.Entity.ApplicationEntity;
import com.project.CensusProfiling.Exception.ApplicationAlreadyExistsException;
import com.project.CensusProfiling.Exception.ApplicationNotFoundException;

public interface IApplicationService {
	
	public List<ApplicationEntity> getAllApplications();
	
	public Optional<ApplicationEntity> getApplication(int id) throws ApplicationNotFoundException;
	
	public ApplicationEntity addApplication(ApplicationEntity  applicationEntity) throws ApplicationAlreadyExistsException;
	
	public Optional<ApplicationEntity> deleteApplication(int id) throws ApplicationNotFoundException;
	
	public ApplicationEntity updateApplication(int id, ApplicationEntity applicationEntity) throws ApplicationNotFoundException;

}
