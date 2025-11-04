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
	public void validate(Object... data) {
		
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
		StringValueIsPresentRule.executeRule(data.getFirstName(), "primer nombre", true);
		StringValueIsPresentRule.executeRule(data.getLastName(), "apellido", true);
		StringValueIsPresentRule.executeRule(data.getUsername(), "nombre de usuario", true);
		StringValueIsPresentRule.executeRule(data.getEmail(), "email", true);
		StringValueIsPresentRule.executeRule(data.getPasswordHash(), "contraseña", false);
	}
	
	protected void validateDataLength(final UserDomain data) {
		StringLengthValueIsValidRule.executeRule(data.getFirstName(), "primer nombre",3, 60, true);
		StringLengthValueIsValidRule.executeRule(data.getLastName(), "apellido",3, 60, true);
		StringLengthValueIsValidRule.executeRule(data.getUsername(), "nombre de usuario",3, 50, true);
		StringLengthValueIsValidRule.executeRule(data.getEmail(), "email",10, 60, true);
		StringLengthValueIsValidRule.executeRule(data.getPasswordHash(), "contraseña",8, 64, false);
	}
	
	protected void validateDataFormat(final UserDomain data) {
		StringFormatValueIsValidRule.executRule(data.getFirstName(), "primer nombre", "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\\\s]+$", true);
		StringFormatValueIsValidRule.executRule(data.getLastName(), "apellido","^[A-Za-zÁÉÍÓÚáéíóúÑñ\\\\s]+$", true);
		StringFormatValueIsValidRule.executRule(data.getUsername(), "nombre de usuario","^[A-Za-z].*",  true);
		StringFormatValueIsValidRule.executRule(data.getEmail(), "email","^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$",  true);
		StringFormatValueIsValidRule.executRule(data.getPasswordHash(), "contraseña","^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[@$!%*?&.#_\\\\-]).{8,}$",  false);
	}
	
	
	
	
}
