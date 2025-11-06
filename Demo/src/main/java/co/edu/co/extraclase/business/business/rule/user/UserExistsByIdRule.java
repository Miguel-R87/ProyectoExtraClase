package co.edu.co.extraclase.business.business.rule.user;

import java.util.UUID;
import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;
import co.edu.co.extraclase.data.dao.factory.DAOFactory;

public final class UserExistsByIdRule implements Rule {
	
	public static final Rule instance = new UserExistsByIdRule();
	
	private UserExistsByIdRule() {
		
	}
	
	public static void executeRule(Object... data ) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_USER.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var user = daoFactory.getUserDAO().findById(id);
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(user.getId())) {
			var userMessage = MessagesEnum.USER_ERROR_USER_DOES_NOT_EXITS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DOES_NOT_EXITS.getContent() + id;
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
	}
}