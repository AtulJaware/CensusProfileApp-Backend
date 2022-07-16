package com.project.CensusProfiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.CensusProfiling.Entity.Login;
import com.project.CensusProfiling.Exception.LoginAlreadyExistsException;
import com.project.CensusProfiling.Exception.LoginNotFoundException;
import com.project.CensusProfiling.Services.ILoginService;

@ExtendWith(MockitoExtension.class)
class LoginTests {

	@Mock
	ILoginService iLoginService;

	@Test
	void addLoginTest() throws LoginAlreadyExistsException {
		Login login = new Login("qaz@qaz.com","qwerty","user");
		when(iLoginService.addLogin(login)).thenReturn(login);
		assertEquals(iLoginService.addLogin(login),login);
	}
	
	@Test
	void getLoginTest() throws LoginNotFoundException {
		Login login = new Login("qaz@qaz.com","qwerty","user");
		Optional<Login> OLoginEntity = Optional.of(login);
		when(iLoginService.getLogin("qaz@qaz.com")).thenReturn(OLoginEntity);
		assertEquals(iLoginService.getLogin("qaz@qaz.com").get(),login);
	}
	
	@Test
	void updateLoginTest() throws LoginNotFoundException {
		Login login = new Login("qaz@qaz.com","qwerty","user");
		when(iLoginService.updateLogin("qaz@qaz.com",login)).thenReturn(login);
		assertEquals(iLoginService.updateLogin("qaz@qaz.com",login),login);
	}
	
	@Test
	void deleteLoginTest() throws LoginNotFoundException {
		Login login = new Login("qaz@qaz.com","qwerty","user");
		Optional<Login> OLoginEntity = Optional.of(login);
		when(iLoginService.deleteLogin("qaz@qaz.com")).thenReturn(OLoginEntity);
		assertEquals(iLoginService.deleteLogin("qaz@qaz.com").get(),login);
	}

}
