package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.AdminEntity;
import com.project.CensusProfiling.Exception.AdminAlreadyExistsException;
import com.project.CensusProfiling.Exception.AdminNotFoundException;
import com.project.CensusProfiling.Services.IAdminService;

@ExtendWith(MockitoExtension.class)
public class AdminTests {

	@Mock
	IAdminService iAdminService;

	@Test
	void addAdminTest() throws AdminAlreadyExistsException {
		AdminEntity adminEntity = new AdminEntity("name1","7412589630","qaz@qaz.com","qwerty");
		when(iAdminService.addAdmin(adminEntity)).thenReturn(adminEntity);
		assertEquals(iAdminService.addAdmin(adminEntity),adminEntity);
	}
	
	@Test
	void getAdminTest() throws AdminNotFoundException {
		AdminEntity adminEntity = new AdminEntity("name1","7412589630","qaz@qaz.com","qwerty");
		Optional<AdminEntity> OAdminEntity = Optional.of(adminEntity);
		when(iAdminService.getAdmin("qaz@qaz.com")).thenReturn(OAdminEntity);
		assertEquals(iAdminService.getAdmin("qaz@qaz.com").get(),adminEntity);
	}
	
	@Test
	void updateAdminTest() throws AdminNotFoundException {
		AdminEntity adminEntity = new AdminEntity("name1","7412589630","qaz@qaz.com","qwerty");
		when(iAdminService.updateAdmin("qaz@qaz.com",adminEntity)).thenReturn(adminEntity);
		assertEquals(iAdminService.updateAdmin("qaz@qaz.com",adminEntity),adminEntity);
	}
	
	@Test
	void deleteAdminTest() throws AdminNotFoundException {
		AdminEntity adminEntity = new AdminEntity("name1","7412589630","qaz@qaz.com","qwerty");
		Optional<AdminEntity> OAdminEntity = Optional.of(adminEntity);
		when(iAdminService.deleteAdmin("qaz@qaz.com")).thenReturn(OAdminEntity);
		assertEquals(iAdminService.deleteAdmin("qaz@qaz.com").get(),adminEntity);
	}

}
