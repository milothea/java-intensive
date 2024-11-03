package src.service;

import java.math.BigDecimal;

import src.model.ApartmentReservation;

public class RegisterService {
    private static int apartmentsCounter = 0;
    public RegisterService() {}

    public ApartmentReservation registerApartment(BigDecimal price) {
        int apartmentNumber = this.getCounter() + 1;

        this.setCounter(apartmentNumber);

        return new ApartmentReservation(price, apartmentNumber);
    }

    private int getCounter() {
        return this.apartmentsCounter;
    }

    private void setCounter(int value) {
        this.apartmentsCounter = value;
    }
}