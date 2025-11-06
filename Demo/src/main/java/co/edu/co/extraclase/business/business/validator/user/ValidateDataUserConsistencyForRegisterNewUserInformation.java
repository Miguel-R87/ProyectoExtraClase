package co.edu.co.extraclase.business.business.validator.user;

import co.edu.co.extraclase.business.business.rule.generics.StringFormatValueIsValidRule;
import co.edu.co.extraclase.business.business.rule.generics.StringLengthValueIsValidRule;
import co.edu.co.extraclase.business.business.rule.generics.StringValueIsPresentRule;
import co.edu.co.extraclase.business.business.validator.Validator;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class ValidateDataUserConsistencyForRegisterNewUserInformation implements Validator {
	
	public static final Validator instance = new ValidateDataUserConsistencyForRegisterNewUserInformation();
	
	private ValidateDataUserConsistencyForRegisterNewUserInformation() {
		
	}
	
	public static void executeValidation(final Object...data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_USER_IS_NOT_PRESENT.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 1) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_IS_NOT_PRESENT.getContent();
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var userDomain = (UserDomain) data[0];
		
		validateEmptyData(userDomain);
		validateDataLength(userDomain);
		validateDataFormat(userDomain);
	}
	
	protected void validateEmptyData(final UserDomain data) {
		StringValueIsPresentRule.executeRule(data.getFirstName(), MessagesEnum.USER_FIRST_NAME.getTitle(), true);
		StringValueIsPresentRule.executeRule(data.getLastName(), MessagesEnum.USER_LAST_NAME.getTitle(), true);
		StringValueIsPresentRule.executeRule(data.getUsername(), MessagesEnum.USER_USERNAME.getTitle(), true);
		StringValueIsPresentRule.executeRule(data.getEmail(), MessagesEnum.USER_EMAIL.getTitle(), true);
		StringValueIsPresentRule.executeRule(data.getPasswordHash(), MessagesEnum.USER_PASSWORDHASH.getTitle(), false);
	}
	
	protected void validateDataLength(final UserDomain data) {
		StringLengthValueIsValidRule.executeRule(data.getFirstName(), MessagesEnum.USER_FIRST_NAME.getTitle(), 3, 60, true);
		StringLengthValueIsValidRule.executeRule(data.getLastName(), MessagesEnum.USER_LAST_NAME.getTitle(), 3, 60, true);
		StringLengthValueIsValidRule.executeRule(data.getUsername(), MessagesEnum.USER_USERNAME.getTitle(), 3, 50, true);
		StringLengthValueIsValidRule.executeRule(data.getEmail(), MessagesEnum.USER_EMAIL.getTitle(), 10, 60, true);
		StringLengthValueIsValidRule.executeRule(data.getPasswordHash(), MessagesEnum.USER_PASSWORDHASH.getTitle(), 8, 64, false);
	}
	
	protected void validateDataFormat(final UserDomain data) {
		StringFormatValueIsValidRule.executRule(data.getFirstName(), MessagesEnum.USER_FIRST_NAME, MessagesEnum.USER_DATA_FORMAT_FIRST_NAME_AND_LAST_NAME.getTitle(), true);
		StringFormatValueIsValidRule.executRule(data.getLastName(), MessagesEnum.USER_LAST_NAME, MessagesEnum.USER_DATA_FORMAT_FIRST_NAME_AND_LAST_NAME.getTitle(), true);
		StringFormatValueIsValidRule.executRule(data.getUsername(), MessagesEnum.USER_USERNAME, MessagesEnum.USER_DATA_FORMAT_USERNAME.getTitle(),  true);
		StringFormatValueIsValidRule.executRule(data.getEmail(), MessagesEnum.USER_EMAIL, MessagesEnum.USER_DATA_FORMAT_EMAIL.getTitle(),  true);
		StringFormatValueIsValidRule.executRule(data.getPasswordHash(), MessagesEnum.USER_PASSWORDHASH, MessagesEnum.USER_DATA_FORMAT_PASSWORDHASH.getTitle(), false);
	}	
}
