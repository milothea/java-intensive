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
        System.out.println("Enter 'apart' to book an apartment. Enter 'book' to open books' order.");
        System.out.println("Enter 'stop' to quit the app.");

        Scanner input = new Scanner(System.in);
        String action = input.nextLine();

        if (action.equalsIgnoreCase(Actions.APART.toString())) {
            makeApartmentReservation(input);
        }

        if (action.equalsIgnoreCase(Actions.BOOK.toString())) {
            placeBooksOrder(input);
        }
    }

    private static void makeApartmentReservation(Scanner scanner) {
        System.out.println("Enter price for apartment reservation:");

        RegisterService registerService = new RegisterService();
        String userInput;

        while (true) {
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(Actions.STOP.toString())) {
                break;
            }

            try {
                BigDecimal price = new BigDecimal(userInput);
                ApartmentReservation reservation = registerService.registerApartment(price);

                System.out.println(reservation.getReservationData());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Please check. It should be number.");
            }
        }
    }

    private static void placeBooksOrder(Scanner scanner) {
        System.out.println("Enter books for order using comma without spaces:");

        OrderService orderService = new OrderService();
        String userInput;

        while (true) {

            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(Actions.STOP.toString())) {
                break;
            }

            try {
                String[] books = userInput.split(",");
                Order newOrder = orderService.createNewOrder(books);

                System.out.println(newOrder.getOrderData());
            } catch (NullPointerException exception) {
                System.out.println("Wrong input.");
            }
        }
    }
}
