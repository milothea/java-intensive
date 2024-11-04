package src;

import java.math.BigDecimal;
import java.util.Scanner;

import src.model.Order;
import src.service.OrderService;
import src.service.RegisterService;
import src.model.ApartmentReservation;
import src.constants.Actions;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
            Enter 'apart' to book an apartment. Enter 'book' to open books' order.
            Enter 'stop' to quit the app.""");

        RegisterService registerService = new RegisterService();
        OrderService orderService = new OrderService();
        Scanner input = new Scanner(System.in);
        String action = input.nextLine();

        if (action.equalsIgnoreCase(Actions.APART.toString())) {
            makeApartmentReservation(input, registerService);
        }

        if (action.equalsIgnoreCase(Actions.BOOK.toString())) {
            placeBooksOrder(input, orderService);
        }
    }

    private static void makeApartmentReservation(Scanner scanner, RegisterService service) {
        System.out.println("Enter price for apartment reservation:");

        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(Actions.STOP.toString())) {
            return;
        }

        try {
            BigDecimal price = new BigDecimal(userInput);
            ApartmentReservation reservation = service.registerApartment(price);

            System.out.println(reservation.getReservationData());
            makeApartmentReservation(scanner, service);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input. Please check. It should be number.");
        }
    }

    private static void placeBooksOrder(Scanner scanner, OrderService service) {
        System.out.println("Enter books for order using comma without spaces:");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(Actions.STOP.toString())) {
            return;
        }

        try {
            String[] books = userInput.split(",");
            Order newOrder = service.createNewOrder(books);

            System.out.println(newOrder.getOrderData());
            placeBooksOrder(scanner, service);
        } catch (NullPointerException exception) {
            System.out.println("Wrong input.");
        }
    }
}
