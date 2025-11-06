package co.edu.co.extraclase.business.business.validator.user;

import co.edu.co.extraclase.business.business.rule.user.UserEmailDoesNotExistRule;
import co.edu.co.extraclase.business.business.validator.Validator;

public final class ValidateUserEmailDoesNotExist implements Validator {
	
	public static final Validator instance = new ValidateUserEmailDoesNotExist();
	
	private ValidateUserEmailDoesNotExist() {
		
	}
	
	public static void executeValidation(final Object...data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		UserEmailDoesNotExistRule.executeRule(data);
	}
}
