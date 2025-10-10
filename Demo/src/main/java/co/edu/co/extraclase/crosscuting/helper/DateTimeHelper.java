package co.edu.co.extraclase.crosscuting.helper;
import java.time.LocalDateTime;

public final class DateTimeHelper {
	private static final LocalDateTime EMPTY = LocalDateTime.of(2500, 12, 31, 0, 0, 0);


    private DateTimeHelper() {
        
    }

    public static LocalDateTime getDefault() {
        return EMPTY;
    }

    public static LocalDateTime getDefault(final LocalDateTime value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static boolean isEmpty(final LocalDateTime value) {
        return EMPTY.equals(getDefault(value));
    }
}	