package co.edu.co.extraclase.business.business;

import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.business.domain.UserDomain;

public interface UserBusiness {
	
		void registerNewUserInformation(final UserDomain userDomain);
	      
		UserDomain loginUser(final String Email, final String passwordHash);

		void updateUserInformation(final UUID id, final UserDomain userDomain);

		void sendUserEmailConfirmationCode(final UUID id);

		void sendSuperUserConfirmationCode(final UUID id);

		boolean confirmCode(final UUID id, final String code, final String confirmationType);

	    List<UserDomain> findUsersByFilter(final UserDomain userFilters);
	
}
