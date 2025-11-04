package co.edu.co.extraclase.business.business.rule.generics;

import java.util.UUID;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class UUIDValueIsPresentRule implements Rule {
	
	public static final Rule instance = new UUIDValueIsPresentRule();
	
	private UUIDValueIsPresentRule() {
		
	}
	
	public static void executeRule(Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_LENGTH_IS_PRESENT.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var uuidData = (UUID) data[0];
		var dataName = (String) data[1];
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(uuidData)) {
			var userMessage= MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage= MessagesEnum.TECHNICAL_ERROR_UUID_IS_DEFAULT.getContent().concat(dataName);

			throw ExtraClaseException.create(userMessage, technicalMessage);
	}
		
	}
}
