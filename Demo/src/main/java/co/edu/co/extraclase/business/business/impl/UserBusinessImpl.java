package co.edu.co.extraclase.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.extraclase.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.co.extraclase.business.business.UserBusiness;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;
import co.edu.co.extraclase.data.dao.factory.DAOFactory;
import co.edu.co.extraclase.entity.UserEntity;

public class UserBusinessImpl implements UserBusiness {
	private DAOFactory daoFactory;
	
	public UserBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}
	
	
	@Override
	public void registerNewUserInformation(UserDomain userDomain) {
		validateDuplicateUser(userDomain);
		validateUserDataConsistency(userDomain);
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		while (!UUIDHelper.getUUIDHelper().isDefaultUUID(daoFactory.getUserDAO().findById(id).getId())) {
			id = UUIDHelper.getUUIDHelper().generateNewUUID();
		}

		userDomain.setId(id);

		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
	
		userEntity.setRegistrationDate(DateTimeHelper.now());
		daoFactory.getUserDAO().create(userEntity);
	}
		
		
		private void validateUserDataConsistency (final UserDomain userDomain) {
			if (ObjectHelper.isNull(userDomain)) {
				var userMessage = MessagesEnum.USER_ERROR_WHEN_REGISTERING_USER_NULL_USER.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHEN_REGISTERING_USER_NULL_USER.getContent();
		        throw ExtraClaseException.create(userMessage, technicalMessage);
		    }

		    if (TextHelper.isEmptyWithTrim(userDomain.getUsername()) || userDomain.getUsername().length() < 3 || userDomain.getUsername().length() > 50) {
		        var userMessage = MessagesEnum.USER_ERROR_WHEN_REGISTERING_USER_INVALID_USERNAME.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_USERNAME.getContent();
		        throw ExtraClaseException.create(userMessage, technicalMessage);
		    }

		    if (!TextHelper.isValidEmail(userDomain.getEmail()) || userDomain.getEmail().length() < 10 || userDomain.getEmail().length() > 60) {
		        var userMessage = MessagesEnum.USER_ERROR_WHEN_REGISTERING_USER_INVALID_EMAIL.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_EMAIL.getContent();
		        throw ExtraClaseException.create(userMessage, technicalMessage);
		    }

		    if (TextHelper.isEmptyWithTrim(userDomain.getFirstName()) || userDomain.getFirstName().length() < 3|| userDomain.getFirstName().length() > 60) {
		        var userMessage = MessagesEnum.USER_ERROR_WHEN_REGISTERING_USER_INVALID_FIRST_NAME.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_FIRST_NAME.getContent();
		        throw ExtraClaseException.create(userMessage, technicalMessage);
		    }

		    if (TextHelper.isEmptyWithTrim(userDomain.getLastName()) || userDomain.getLastName().length() < 3 || userDomain.getLastName().length() > 60) {
		        var userMessage = MessagesEnum.USER_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME.getContent();
		        throw ExtraClaseException.create(userMessage, technicalMessage);
		    }
		    if (TextHelper.isValidPasswordHash(userDomain.getPasswordHash()) || userDomain.getPasswordHash().length() < 8 || userDomain.getLastName().length() > 64) {
		        var userMessage = MessagesEnum.USER_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME.getContent();
		        throw ExtraClaseException.create(userMessage, technicalMessage);
		    }
		}

		private void validateDuplicateUser (final UserDomain userDomain) {

			var userEntityFilter = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
			var userDAO = daoFactory.getUserDAO();

			var filterByUsername = new UserEntity();
			filterByUsername.setUsername(userEntityFilter.getUsername());
			var existingByUsername = userDAO.findByFilter(filterByUsername);
			if (!existingByUsername.isEmpty()) {
				var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_USERNAME.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_USERNAME.getContent();
				throw ExtraClaseException.create(userMessage, technicalMessage);
			}

			var filterByEmail = new UserEntity();
			filterByEmail.setEmail(userEntityFilter.getEmail());
			var existingByEmail = userDAO.findByFilter(filterByEmail);
			if (!existingByEmail.isEmpty()) {
				var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL.getContent();
				throw ExtraClaseException.create(userMessage, technicalMessage);
			}
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
	public List<UserDomain> findUsersByFilter(UserDomain userFilters) {

		var userFiltersEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userFilters);
		
		var userEntities = daoFactory.getUserDAO().findByFilter(userFiltersEntity);
		
		return UserEntityAssembler.getUserEntityAssembler().toDomain(userEntities); 
	}

}