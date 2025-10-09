package co.edu.co.extraclase.crosscuting.helper;
import java.time.LocalDate;

public final class DateHelper {
	private static final LocalDate EMPTY = LocalDate.of(1900, 1, 1);


    private DateHelper() {
        
    }

    public static LocalDate getDefault() {
        return EMPTY;
    }

    public static LocalDate getDefault(final LocalDate value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static boolean isEmpty(final LocalDate value) {
        return EMPTY.equals(getDefault(value));
    }
}	