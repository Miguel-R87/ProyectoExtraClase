package co.edu.co.extraclase.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.co.extraclase.dto.UserDto;
import co.edu.co.extraclase.business.facade.impl.UserFacadeImpl;
import co.edu.co.extraclase.controller.dto.Response;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;


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
		responseObjectData.addMessage(" User registered sucesfully");
		
		
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

	
	@GetMapping
	public ResponseEntity<Response<UserDto>> findUsersByFilter(
			@RequestParam(required = false) UUID id,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String email) {

		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;

		try {
			var facade = new UserFacadeImpl();
			var filter = new UserDto();
			if (id != UUIDHelper.getUUIDHelper().getDefault()) {
				filter.setId(id);
			}
			if (username != TextHelper.getDefault()) {
				filter.setUsername(username);
			}
			if (email != TextHelper.getDefault()) {
				filter.setEmail(email);
			}

			var users = facade.findUsersByFilter(filter);
			responseObjectData = Response.createSuccededResponse(users);

		} catch (final ExtraClaseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (final Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}

		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}

}