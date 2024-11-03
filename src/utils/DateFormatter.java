package src.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public DateFormatter() {}

    public String formatDate(LocalDateTime date) {
        return date.format(this.formatter);
    }
}
