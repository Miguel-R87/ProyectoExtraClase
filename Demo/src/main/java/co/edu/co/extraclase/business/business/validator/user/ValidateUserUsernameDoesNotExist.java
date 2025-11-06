package co.edu.co.extraclase.business.business.validator.user;

import co.edu.co.extraclase.business.business.rule.user.UserUsernameDoesNotExistRule;
import co.edu.co.extraclase.business.business.validator.Validator;

public final class ValidateUserUsernameDoesNotExist implements Validator {
	
	public static final Validator instance = new ValidateUserUsernameDoesNotExist();

	private ValidateUserUsernameDoesNotExist() {
		
	}
	
	public static void executeValidation(final Object...data) {
		instance.validate(data);
	}
	
	@Override
	public void validate(final Object... data) {
		UserUsernameDoesNotExistRule.executeRule(data);
	}
}
