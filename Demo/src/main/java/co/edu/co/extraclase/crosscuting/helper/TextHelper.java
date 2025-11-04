package co.edu.co.extraclase.crosscuting.helper;

public final class TextHelper {
	private static final String EMPTY = "";

	private TextHelper() {
	}

	public static String getDefault() {
		return EMPTY;
	}

	public static String getDefault(final String value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

	public static String getDefaultWithTrim(final String value) {
		return getDefault(value).trim();
	}
	
	public static boolean isEmpty(final String value) {
		return EMPTY.equals(getDefault(value));
	}
	
	public static boolean isEmptyWithTrim(final String value) {
		return EMPTY.equals(getDefaultWithTrim(value));
	}
	
	public static boolean isValidEmail(final String value) {
	    final var email = getDefaultWithTrim(value);
	    return !isEmpty(email) && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	}	
	 
	 public static boolean isValidPasswordHash(final String value) {
		    final var password = value;
		    return !isEmpty(password) 
		        && password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&.#_\\-]).{8,}$");
	}
	 
	 public static boolean lengthIsValid(final String value, final int min, final int max, final boolean mustApplyTrim) {
		 var valueToValidate = mustApplyTrim ? getDefaultWithTrim(value) : getDefault(value);
		 var length = valueToValidate.length();
		 return length >= min && length <= max; 
	}

	 public static boolean lengthIsValidWithTrim(final String value, final int min, final int max) {
		 return lengthIsValid(getDefaultWithTrim(value), min, max, true); 
	}

	 public static boolean formatIsValid(final String value, final String pattern, final boolean mustApplyTrim) {
		 var text = (mustApplyTrim ? getDefaultWithTrim(value) : getDefault());
		 return text.matches(pattern);
	}

	 public static boolean isValidFirstName(final String value) {
		 final var name = getDefaultWithTrim(value);
		 return !isEmpty(name) && name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$");
	}

	public static boolean isValidLastName(final String value) {
		 final var name = getDefaultWithTrim(value);
		 return !isEmpty(name) && name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$");
	}
	
	public static boolean isValidUsername(final String value) {
	    final var username = getDefaultWithTrim(value);
	    return !isEmptyWithTrim(value) && username.matches("^[A-Za-z].*");
	}
}
 
