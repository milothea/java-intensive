package src.service;

import java.math.BigDecimal;

import src.model.ApartmentReservation;

public class RegisterService {
    private int apartmentCounter;
    public RegisterService() {}

    public ApartmentReservation registerApartment(BigDecimal price) {
        int apartmentNumber = this.getCounter() + 1;

        this.setCounter(apartmentNumber);

        return new ApartmentReservation(price, apartmentNumber);
    }

    private int getCounter() {
        return this.apartmentCounter;
    }

    private void setCounter(int value) {
        this.apartmentCounter = value;
    }
}