package co.edu.co.extraclase.business.business.rule.generics;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class StringValueIsPresentRule implements Rule{
	
	public static final Rule instance = new StringValueIsPresentRule();
	
	private StringValueIsPresentRule() {
		
	}
	
	public static void executeRule(final Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
	
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 3) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_LENGTH_IS_PRESENT.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var stringdata = (String) data[0];
		var dataName = (String) data[1];
		boolean mustApplyTrim = (Boolean) data[2];
		
		if ((mustApplyTrim)
				? TextHelper.isEmptyWithTrim(stringdata)
						: TextHelper.isEmpty(stringdata)) {
			var userMessage = MessagesEnum.USER_ERROR_INCOMPLETE_PARAMETERS.getContent().concat(dataName);
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INCOMPLETE_PARAMETERS.getContent().concat(dataName);
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
	}		
}


