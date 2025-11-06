package co.edu.co.extraclase.business.facade;

import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.dto.UserDto;

public interface UserFacade {

	void registerNewUserInformation(UserDto userDto);
      
	UserDomain loginUser(final String Email, final String passwordHash);

	void updateUserInformation(UUID id,UserDto userDto);

	void sendUserEmailConfirmationCode(final UUID id);

	void sendSuperUserConfirmationCode(final UUID id);

	boolean confirmCode(final UUID id, final String code, final String confirmationType);

    List<UserDto> findUsersByFilter(UserDto userFilters);

}

