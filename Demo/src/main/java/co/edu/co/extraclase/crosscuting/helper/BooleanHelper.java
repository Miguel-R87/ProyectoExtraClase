package co.edu.co.extraclase.crosscuting.helper;

public final class BooleanHelper {

	private static final boolean DEFAULT_VALUE = false;

	private BooleanHelper() {
	}

	public static boolean getDefault() {
		return DEFAULT_VALUE;
	}

	public static boolean getDefault(final Boolean value) {
		return ObjectHelper.getDefault(value, DEFAULT_VALUE);
	}

	public static boolean isDefaultBoolean(final Boolean value) {
		return ObjectHelper.getDefault(value, DEFAULT_VALUE) == DEFAULT_VALUE;
	}
}
