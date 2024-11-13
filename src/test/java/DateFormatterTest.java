import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.DateFormatter;

import java.time.LocalDateTime;

public class DateFormatterTest {
    @Test
    void formatDate() {
        LocalDateTime date = LocalDateTime.of(2024,1,2,3,4);
        String formattedDate = DateFormatter.formatDate(date);

        assertNotNull(formattedDate);
        assertTrue(formattedDate.equalsIgnoreCase("02-01-2024"));
    }
}
