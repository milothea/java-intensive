package service;

import java.math.BigDecimal;
import java.util.Scanner;

import constants.Action;
import model.ApartmentReservation;
import utils.StringsComparator;

public class RegisterService {
    private static int APARTMENTS_COUNTER;
    public RegisterService() {}

    public ApartmentReservation makeApartmentReservation(Scanner scanner) {
        System.out.println("Enter price for apartment reservation:");
        String userInput = scanner.nextLine();

        if (!StringsComparator.isEqual(userInput, Action.STOP)) {
            try {
                BigDecimal price = new BigDecimal(userInput);
                ApartmentReservation reservation = registerApartment(price);

                System.out.println(reservation.getReservationData());

                return reservation;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Please check. It should be number.");
            }
        }

        return null;
    }

    private ApartmentReservation registerApartment(BigDecimal price) {
        int apartmentNumber = getCounter() + 1;

        setCounter(apartmentNumber);

        return new ApartmentReservation(price, apartmentNumber);
    }

    private int getCounter() {
        return APARTMENTS_COUNTER;
    }

    private void setCounter(int value) {
        APARTMENTS_COUNTER = value;
    }
}