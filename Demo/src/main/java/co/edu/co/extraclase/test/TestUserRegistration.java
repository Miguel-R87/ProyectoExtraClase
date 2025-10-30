package co.edu.co.extraclase.test;

import java.time.LocalDateTime;

import co.edu.co.extraclase.business.facade.impl.UserFacadeImpl;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.dto.UserDto;

public class TestUserRegistration {
	
	public static void main (String[] args) {
		
		try {
			var user = new UserDto();
			
			user.setFirstName("Andres ");
			user.setLastName("Arango");
			user.setUsername("Andrucracksito");
			user.setEmail("andres9@gmail.com");
			user.setRegistrationDate(LocalDateTime.now());
			user.setPasswordHash("Tijooooo2");
			user.setAccountStatus(false);
			user.setSuperUser(false);
			user.setSuperUserConfirmation(false);
			user.setEmailConfirmation(false);
			
			var facade = new UserFacadeImpl();
			facade.registerNewUserInformation(user);
			
			System.out.println("Ganamos el semestre");
			
		}catch(ExtraClaseException e) {
			System.out.println(e.getUserMessage());
			System.out.println(e.getTechnicalMessage());
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
