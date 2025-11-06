package co.edu.co.extraclase.crosscuting.helper;

public final class NumberHelper {

    private static final Integer ZERO = 0;

    private NumberHelper() {
       
    }
    
    public static int getDefault() {
		return ZERO;
	}	
    
    public static int getDefault(final Integer value) {
        return ObjectHelper.getDefault(value, ZERO);
    }
    
    public static boolean isZero(final Integer value) {
    	return ZERO.equals(getDefault(value));	
    }
}