package co.edu.co.extraclase.test;

import java.time.LocalDateTime;
import co.edu.co.extraclase.business.facade.impl.UserFacadeImpl;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.dto.UserDto;

public class TestUserRegistration {
	
	public static void main (String[] args) {
		
		try {
			var user = new UserDto();
			
			user.setFirstName("Kris");
			user.setLastName("Rrrrrr");
			user.setUsername("LaKbra2");
			user.setEmail("majoflores1245@gmail.com");
			user.setRegistrationDate(LocalDateTime.now());
			user.setPasswordHash("Blesdd*1");
			user.setAccountStatus(false);
			user.setSuperUser(false);
			user.setSuperUserConfirmed(false);
			user.setEmailConfirmed(false);
			
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
