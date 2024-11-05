package src;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import src.model.Order;
import src.service.OrderService;
import src.service.RegisterService;
import src.model.ApartmentReservation;
import src.constants.Actions;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
            Enter 'apart' to book an apartment. Enter 'book' to open books' order. Maximum 5 entries.book
            Enter 'stop' to quit the app.""");

        RegisterService registerService = new RegisterService();
        OrderService orderService = new OrderService();
        Scanner input = new Scanner(System.in);
        String action = input.nextLine();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<ApartmentReservation> reservations = new ArrayList<>();

        do {
            if (isEqual(action, Actions.APART)) {
                ApartmentReservation reservation = makeApartmentReservation(input, registerService);

                if (reservation == null) {
                    action = Actions.STOP.toString();
                } else {
                    reservations.add(reservation);
                }
            }

            if (isEqual(action, Actions.BOOK)) {
                Order order = placeBooksOrder(input, orderService);

                if (order == null) {
                    action = Actions.STOP.toString();
                } else {
                    orders.add(order);
                }
            }

        } while(!isEqual(action, Actions.STOP));
    }

    private static ApartmentReservation makeApartmentReservation(Scanner scanner, RegisterService service) {
        System.out.println("Enter price for apartment reservation:");
        String userInput = scanner.nextLine();

        if (!isEqual(userInput, Actions.STOP)) {
            try {
                BigDecimal price = new BigDecimal(userInput);
                ApartmentReservation reservation = service.registerApartment(price);

                System.out.println(reservation.getReservationData());

                return reservation;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Please check. It should be number.");
            }
        }

        return null;
    }

    private static Order placeBooksOrder(Scanner scanner, OrderService service) {
        System.out.println("Enter books for order using comma without spaces:");
        String userInput = scanner.nextLine();

        if (!isEqual(userInput, Actions.STOP)) {
            try {
                String[] books = userInput.split(",");
                Order order = service.createNewOrder(books);

                System.out.println(order.getOrderData());

                return order;
            } catch (NullPointerException exception) {
                System.out.println("Wrong input.");
            }
        }

        return null;
    }

    private static boolean isEqual(String string, Actions action) {
        return action.toString().toLowerCase().equals(string.toLowerCase());
    }
}
