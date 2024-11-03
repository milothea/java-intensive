package src.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import src.utils.DateFormatter;

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
        LocalDateTime date = this.getDate();

        return String.format(
                "Reservation of the apartment No. %d is made on %s with price %s",
                this.apartmentNumber, DateFormatter.formatDate(date), this.price
        );
    }

    public LocalDateTime getDate() {
        return this.bookingDate;
    }


}
