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


}
 
