package co.edu.co.extraclase.business.business.validator.user;

import co.edu.co.extraclase.business.business.rule.user.UserEmailDoesNotExistRule;
import co.edu.co.extraclase.business.business.validator.Validator;

public class ValidateUserEmailDoesNotExist implements Validator {
	
	public static final Validator instance = new ValidateUserEmailDoesNotExist();
	
	private ValidateUserEmailDoesNotExist() {
		
	}
	
	public static void executeValidation(Object...data) {
		instance.validate(data);
	}

	@Override
	public void validate(Object... data) {
		UserEmailDoesNotExistRule.executeRule(data);
		
	}

}
