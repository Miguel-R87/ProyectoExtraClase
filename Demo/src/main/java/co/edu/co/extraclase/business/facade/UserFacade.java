package co.edu.co.extraclase.business.facade;

import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.dto.UserDto;

public interface UserFacade {

	void registerNewUserInformation(UserDto userDto);
      
	UserDomain loginUser(String Email, String passwordHash);

	void updateUserInformation(UUID id, UserDto userDto);

	void sendUserEmailConfirmationCode(UUID id);

	void sendSuperUserConfirmationCode(UUID id);

	boolean confirmCode(UUID id, String code, String confirmationType);

    List<UserDto> findUsersByFilter(UserDto userFilters);

}

