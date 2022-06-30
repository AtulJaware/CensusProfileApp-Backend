package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.LoginEntity;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;
import com.project.CensusProfiling.Services.ILoginService;

@ExtendWith(MockitoExtension.class)
class LoginTests {

	@Mock
	ILoginService iLoginService;

	@Test
	void addLoginTest() throws LoginAlreadyExistsException {
		LoginEntity loginEntity = new LoginEntity("qaz@qaz.com","qwerty","user");
		when(iLoginService.addLogin(loginEntity)).thenReturn(loginEntity);
		assertEquals(iLoginService.addLogin(loginEntity),loginEntity);
	}
	
	@Test
	void getLoginTest() throws LoginNotFoundException {
		LoginEntity loginEntity = new LoginEntity("qaz@qaz.com","qwerty","user");
		Optional<LoginEntity> OLoginEntity = Optional.of(loginEntity);
		when(iLoginService.getLogin("qaz@qaz.com")).thenReturn(OLoginEntity);
		assertEquals(iLoginService.getLogin("qaz@qaz.com").get(),loginEntity);
	}
	
	@Test
	void updateLoginTest() throws LoginNotFoundException {
		LoginEntity loginEntity = new LoginEntity("qaz@qaz.com","qwerty","user");
		when(iLoginService.updateLogin("qaz@qaz.com",loginEntity)).thenReturn(loginEntity);
		assertEquals(iLoginService.updateLogin("qaz@qaz.com",loginEntity),loginEntity);
	}
	
	@Test
	void deleteLoginTest() throws LoginNotFoundException {
		LoginEntity loginEntity = new LoginEntity("qaz@qaz.com","qwerty","user");
		Optional<LoginEntity> OLoginEntity = Optional.of(loginEntity);
		when(iLoginService.deleteLogin("qaz@qaz.com")).thenReturn(OLoginEntity);
		assertEquals(iLoginService.deleteLogin("qaz@qaz.com").get(),loginEntity);
	}

}
