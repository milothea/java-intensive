import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import model.ApartmentReservation;
import utils.DateFormatter;

class ApartmentReservationTest {

    ApartmentReservation reservation;
    BigDecimal price = new BigDecimal(100);
    String formattedDate = DateFormatter.formatDate(LocalDateTime.now());
    int apartmentNumber;

    @BeforeEach
    void setUp() {
        apartmentNumber += 1;
        reservation = spy(new ApartmentReservation(price, apartmentNumber));
    }

    @Test
    void getReservationData() {
        String expectedResult = String.format(
                "Reservation of the apartment No. %d is made on %s with price %s",
                apartmentNumber, formattedDate, price
        );
        String reservationData = reservation.getReservationData();

        assertNotNull(reservationData);
        assertEquals(expectedResult, reservationData);
    }

    @Test
    void getDateAsString() {
        String dateAsString = reservation.getDateAsString();

        assertNotNull(dateAsString);
        assertTrue(dateAsString.equalsIgnoreCase(formattedDate));
    }
}