package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.Application;
import com.project.CensusProfiling.Exception.ApplicationAlreadyExistsException;
import com.project.CensusProfiling.Exception.ApplicationNotFoundException;
import com.project.CensusProfiling.Services.IApplicationService;

@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	@Mock
	IApplicationService iApplicationService;

	@Test
	void addApplicationTest() throws ApplicationAlreadyExistsException {
		Application application = new Application(1,"pending",2);
		when(iApplicationService.addApplication(application)).thenReturn(application);
		assertEquals(iApplicationService.addApplication(application),application);
	}
	
	@Test
	void getApplicationTest() throws ApplicationNotFoundException {
		Application application = new Application(1,"pending",2);
		Optional<Application> OApplicationEntity = Optional.of(application);
		when(iApplicationService.getApplication(1)).thenReturn(OApplicationEntity);
		assertEquals(iApplicationService.getApplication(1).get(),application);
	}
	
	@Test
	void updateApplicationTest() throws ApplicationNotFoundException {
		Application application = new Application(1,"pending",2);
		when(iApplicationService.updateApplication(1,application)).thenReturn(application);
		assertEquals(iApplicationService.updateApplication(1,application),application);
	}
	
	@Test
	void deleteApplicationTest() throws ApplicationNotFoundException {
		Application application = new Application(1,"pending",2);
		Optional<Application> OApplicationEntity = Optional.of(application);
		when(iApplicationService.deleteApplication(1)).thenReturn(OApplicationEntity);
		assertEquals(iApplicationService.deleteApplication(1).get(),application);
	}

}
