package model;

import utils.DateFormatter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApartmentReservation {
    private int apartmentNumber;
    private BigDecimal price;
    private LocalDateTime bookingDate;

    public ApartmentReservation(BigDecimal price, int apartmentNumber) {
        this.price = price;
        this.apartmentNumber = apartmentNumber;
        this.bookingDate = LocalDateTime.now();
    }

    public String getReservationData() {
        String date = this.getDateAsString();

        return String.format(
                "Reservation of the apartment No. %d is made on %s with price %s",
                this.apartmentNumber, date, this.price
        );
    }

    public String getDateAsString() {
        return DateFormatter.formatDate(this.bookingDate);
    }
}
