package src.service;

import java.math.BigDecimal;

import src.model.ApartmentReservation;

public class RegisterService {
    private int APARTMENTS_COUNTER = 0;
    public RegisterService() {}

    public ApartmentReservation registerApartment(BigDecimal price) {
        int apartmentNumber = this.getCounter() + 1;

        this.setCounter(apartmentNumber);

        return new ApartmentReservation(price, apartmentNumber);
    }

    private int getCounter() {
        return this.APARTMENTS_COUNTER;
    }

    private void setCounter(int value) {
        this.APARTMENTS_COUNTER = value;
    }
}