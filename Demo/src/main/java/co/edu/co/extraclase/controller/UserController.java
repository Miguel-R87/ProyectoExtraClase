package co.edu.co.extraclase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.co.extraclase.dto.UserDto;
import co.edu.co.extraclase.business.facade.impl.UserFacadeImpl;
import co.edu.co.extraclase.controller.dto.Response;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@PostMapping
	public  ResponseEntity<Response<UserDto>> registerNewUserInformation (@RequestBody UserDto user) {		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		facade.registerNewUserInformation(user);
		responseObjectData.addMessage(MessagesEnum.USER_REGISTRATION_SUCCESSFUL.getContent());
	
	} catch (final ExtraClaseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
	
	return new ResponseEntity<>(responseObjectData, responseStatusCode);
	
	}
	
	
}