package co.edu.co.extraclase.business.business.rule.generics;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class StringFormatValueIsValidRule implements Rule{
	
	public static final Rule instance = new StringFormatValueIsValidRule();
	
	private StringFormatValueIsValidRule() {
		
	}
	
	public static void executRule(final Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_FORMAT_VALUE.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 4) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_FORMAT_VALUE.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var pattern = (String) data[2];
		boolean mustApplyTrim = (Boolean) data[3];
		
		if(!TextHelper.formatIsValid(stringData, pattern, mustApplyTrim)) {
			var userMessage= MessagesEnum.USER_ERROR_WRONG_FORMAT.getContent().concat(dataName);
			var technicalMessage= MessagesEnum.TECHNICAL_ERROR_WRONG_FORMAT.getContent().concat(dataName).concat(" ").concat(pattern);
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
	}
}