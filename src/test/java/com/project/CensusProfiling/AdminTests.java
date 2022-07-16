package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.Admin;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.Services.IAdminService;

@ExtendWith(MockitoExtension.class)
public class AdminTests {

	@Mock
	IAdminService iAdminService;

	@Test
	void addAdminTest() throws AdminAlreadyExistsException {
		Admin admin = new Admin(1,"Atul","7412589630","qwerty");
		when(iAdminService.addAdmin(admin)).thenReturn(admin);
		assertEquals(iAdminService.addAdmin(admin),admin);
	}
	
	@Test
	void getAdminTest() throws AdminNotFoundException {
		Admin admin = new Admin(1,"Atul","7412589630","qwerty");
		Optional<Admin> OAdminEntity = Optional.of(admin);
		when(iAdminService.getAdmin(1)).thenReturn(OAdminEntity);
		assertEquals(iAdminService.getAdmin(1).get(),admin);
	}
	
	@Test
	void updateAdminTest() throws AdminNotFoundException {
		Admin admin = new Admin(1,"Atul","7412589630","qwerty");
		when(iAdminService.updateAdmin(1,admin)).thenReturn(admin);
		assertEquals(iAdminService.updateAdmin(1,admin),admin);
	}
	
	@Test
	void deleteAdminTest() throws AdminNotFoundException {
		Admin admin = new Admin(1,"Atul","7412589630","qwerty");
		Optional<Admin> OAdminEntity = Optional.of(admin);
		when(iAdminService.deleteAdmin(1)).thenReturn(OAdminEntity);
		assertEquals(iAdminService.deleteAdmin(1).get(),admin);
	}

}
