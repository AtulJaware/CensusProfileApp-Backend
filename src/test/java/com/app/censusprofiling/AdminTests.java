package com.app.censusprofiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.censusprofiling.entity.Admin;
import com.app.censusprofiling.exception.AdminAlreadyExistsException;
import com.app.censusprofiling.exception.AdminNotFoundException;
import com.app.censusprofiling.services.IAdminService;

@ExtendWith(MockitoExtension.class)
public class AdminTests {

	@Mock
	IAdminService iAdminService;

	@Test
	void addAdminTest() throws AdminAlreadyExistsException {
		Admin admin = new Admin(1,"keerthi","1234567890");
		when(iAdminService.addAdmin(admin)).thenReturn(admin);
		assertEquals(iAdminService.addAdmin(admin),admin);
	}
	
	@Test
	void getAdminTest() throws AdminNotFoundException {
		Admin admin = new Admin(1,"keerthi","1234567890");
		Optional<Admin> OAdminEntity = Optional.of(admin);
		when(iAdminService.getAdmin(1)).thenReturn(OAdminEntity);
		assertEquals(iAdminService.getAdmin(1).get(),admin);
	}
	
	@Test
	void updateAdminTest() throws AdminNotFoundException {
		Admin admin = new Admin(1,"keerthi","1234567890");
		when(iAdminService.updateAdmin(1,admin)).thenReturn(admin);
		assertEquals(iAdminService.updateAdmin(1,admin),admin);
	}
	
	@Test
	void deleteAdminTest() throws AdminNotFoundException {
		Admin admin = new Admin(1,"keerthi","1234567890");
		Optional<Admin> OAdminEntity = Optional.of(admin);
		when(iAdminService.deleteAdmin(1)).thenReturn(OAdminEntity);
		assertEquals(iAdminService.deleteAdmin(1).get(),admin);
	}

}
