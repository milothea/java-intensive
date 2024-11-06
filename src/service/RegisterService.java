package src.service;

import java.math.BigDecimal;
import java.util.Scanner;

import src.constants.Action;
import src.model.ApartmentReservation;
import src.utils.StringsComparator;

public class RegisterService {
    private static int APARTMENTS_COUNTER;
    public RegisterService() {}

    public static ApartmentReservation makeApartmentReservation(Scanner scanner) {
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

    private static ApartmentReservation registerApartment(BigDecimal price) {
        int apartmentNumber = getCounter() + 1;

        setCounter(apartmentNumber);

        return new ApartmentReservation(price, apartmentNumber);
    }

    private static int getCounter() {
        return APARTMENTS_COUNTER;
    }

    private static void setCounter(int value) {
        APARTMENTS_COUNTER = value;
    }
}