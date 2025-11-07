package co.edu.co.extraclase.business.business;

import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.business.domain.UserDomain;

public interface UserBusiness {
	
		void registerNewUserInformation(UserDomain userDomain);
	      
		UserDomain loginUser(String Email, String passwordHash);

		void updateUserInformation(UUID id, UserDomain userDomain);

		void sendUserEmailConfirmationCode(UUID id);

		void sendSuperUserConfirmationCode(UUID id);

		boolean confirmCode(UUID id, String code, String confirmationType);

	    List<UserDomain> findUsersByFilter(UserDomain userFilters);
	
}
