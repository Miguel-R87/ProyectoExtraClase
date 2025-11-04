package co.edu.co.extraclase.business.business.rule.user;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;
import co.edu.co.extraclase.data.dao.factory.DAOFactory;
import co.edu.co.extraclase.entity.UserEntity;

public final class UserUsernameDoesNotExistRule implements Rule {
	public static final Rule instance = new UserUsernameDoesNotExistRule();
	
	private UserUsernameDoesNotExistRule() {
		
	}
	
	public static void executeRule(Object...data) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_USERNAME.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_USERNAME.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var username = (String) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var filter = new UserEntity();
		filter.setUsername(username);
		
		var duplicateUsername = daoFactory.getUserDAO().findByFilter(filter);
		
		if (!duplicateUsername.isEmpty()) { 
	    	var userMessage = MessagesEnum.USER_ERROR_USER_DOES_EXISTS_BY_USERNAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DOES_EXISTS_BY_USERNAME.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage); 
	    }
		
	}

}
