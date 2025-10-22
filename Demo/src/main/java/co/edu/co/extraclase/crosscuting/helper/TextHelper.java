package co.edu.co.extraclase.crosscuting.helper;

public final class TextHelper {
	private static final String EMPTY="";
	private TextHelper() {

	}
	public static String getDefault() {
		return EMPTY;
	}
public static String getDefault(final String value) {
	return ObjectHelper.getDefault(value,  getDefault());
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


}

