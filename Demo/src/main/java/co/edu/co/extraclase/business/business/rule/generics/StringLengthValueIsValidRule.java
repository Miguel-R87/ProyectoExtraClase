package co.edu.co.extraclase.business.business.rule.generics;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class StringLengthValueIsValidRule implements Rule{
	
	private static final Rule instance = new StringLengthValueIsValidRule();
	
	private StringLengthValueIsValidRule() {
		
	}
	
	public static void executeRule(final Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_LENGTH_VALUE.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 5) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_LENGTH_VALUE.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var minLength = (Integer) data[2];
		var maxLength = (Integer) data[3];
		boolean mustApplyTrim = (boolean) data[4];

		if (!TextHelper.lengthIsValid(stringData, minLength, maxLength, mustApplyTrim)) {
			var userMessage = MessagesEnum.USER_ERROR_WRONG_LENGTH.getContent().concat(dataName).concat(" ").concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength));
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_LENGTH.getContent().concat(dataName).concat(" ").concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength));;
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
	}	
}


