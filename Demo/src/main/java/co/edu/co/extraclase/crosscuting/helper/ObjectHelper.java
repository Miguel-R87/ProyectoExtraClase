package co.edu.co.extraclase.crosscuting.helper;

public final class ObjectHelper {
	
	private ObjectHelper() {
	
	}
	
	public static<O> boolean isNull(final O object) {
		return object ==null;
	}
	
	public static<O> O getDefault(final O object,final O defaultValue) {
		if (isNull(object)) {
			return defaultValue; }
		else {
			return object;
		}
	}
}




