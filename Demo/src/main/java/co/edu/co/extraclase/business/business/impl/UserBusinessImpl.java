package co.edu.co.extraclase.business.business.impl;

import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.co.extraclase.business.business.UserBusiness;
import co.edu.co.extraclase.business.business.validator.user.ValidateDataUserConsistencyForRegisterNewUserInformation;
import co.edu.co.extraclase.business.business.validator.user.ValidateUserEmailDoesNotExist;
import co.edu.co.extraclase.business.business.validator.user.ValidateUserUsernameDoesNotExist;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.data.dao.factory.DAOFactory;

public final class UserBusinessImpl implements UserBusiness {
	
	private DAOFactory daoFactory;
	
	public UserBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}
	
	@Override
	public void registerNewUserInformation(final UserDomain userDomain) {
		
		ValidateDataUserConsistencyForRegisterNewUserInformation.executeValidation(userDomain);
		validateUserUsernameDoesNotExist(userDomain.getUsername());
		validateUserEmailDoesNotExist(userDomain.getEmail());
	
		
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		while (!UUIDHelper.getUUIDHelper().isDefaultUUID(daoFactory.getUserDAO().findById(id).getId())) {
			id = UUIDHelper.getUUIDHelper().generateNewUUID();
		}
		
		userDomain.setId(id);

		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
	
		userEntity.setRegistrationDate(DateTimeHelper.now());
		daoFactory.getUserDAO().create(userEntity);
	}
			
			private void validateUserEmailDoesNotExist(final String email) {
				ValidateUserEmailDoesNotExist.executeValidation(email, daoFactory);
			}
			
			private void validateUserUsernameDoesNotExist(final String username) {
				ValidateUserUsernameDoesNotExist.executeValidation(username, daoFactory);
			}

	@Override
	public UserDomain loginUser(String Email, String passwordHash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserInformation(UUID id, UserDomain userDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendUserEmailConfirmationCode(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSuperUserConfirmationCode(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean confirmCode(UUID id, String code, String confirmationType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDomain> findUsersByFilter(final UserDomain userFilters) {

		var userFiltersEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userFilters);
		
		var userEntities = daoFactory.getUserDAO().findByFilter(userFiltersEntity);
		
		return UserEntityAssembler.getUserEntityAssembler().toDomain(userEntities); 
	}

}