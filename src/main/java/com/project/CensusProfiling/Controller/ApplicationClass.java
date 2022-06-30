package com.project.CensusProfiling.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.CensusProfiling.Entity.ApplicationEntity;
import com.project.CensusProfiling.Exception.ApplicationAlreadyExistsException;
import com.project.CensusProfiling.Exception.ApplicationNotFoundException;
import com.project.CensusProfiling.Services.IApplicationService;

@RestController
public class ApplicationClass {
	

	@Autowired
	private IApplicationService iApplicationService;
	

	@GetMapping("/application")
	public List<ApplicationEntity> getAllApplications(){
		return iApplicationService.getAllApplications();
	}
	
	@GetMapping("/application/{id}")
	public Optional<ApplicationEntity> getApplication(@PathVariable int id) throws ApplicationNotFoundException{
		return iApplicationService.getApplication(id);
	}
	
	@PostMapping("/application")
	public ApplicationEntity addApplication(@Valid @RequestBody ApplicationEntity  applicationEntity) throws ApplicationAlreadyExistsException{
		return iApplicationService.addApplication(applicationEntity);
	}
	
	@DeleteMapping("/application/{id}")
	public Optional<ApplicationEntity> deleteApplication(@PathVariable int id) throws ApplicationNotFoundException{
		return iApplicationService.deleteApplication(id);
	}

	@PutMapping("/application/{id}")
	public ApplicationEntity updateApplication(@PathVariable int id, @Valid @RequestBody ApplicationEntity applicationEntity) throws ApplicationNotFoundException{
		return iApplicationService.updateApplication(id, applicationEntity);
	}


}
