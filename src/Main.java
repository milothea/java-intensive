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

        do {
            boolean stopFlag = false;

            if (isEqual(action, Actions.APART)) {
                stopFlag = makeApartmentReservation(input, registerService);
            }

            if (isEqual(action, Actions.BOOK)) {
                stopFlag = placeBooksOrder(input, orderService);
            }

            if (stopFlag) {
                break;
            }
        } while (!isEqual(action, Actions.STOP));
    }

    private static boolean makeApartmentReservation(Scanner scanner, RegisterService service) {
        System.out.println("Enter price for apartment reservation:");
        String userInput = scanner.nextLine();

        if (isEqual(userInput, Actions.STOP)) {
            return true;
        }

        try {
            BigDecimal price = new BigDecimal(userInput);
            ApartmentReservation reservation = service.registerApartment(price);

            System.out.println(reservation.getReservationData());
        } catch (NumberFormatException e) {
            System.out.println("Wrong input. Please check. It should be number.");
        }

        return false;
    }

    private static boolean placeBooksOrder(Scanner scanner, OrderService service) {
        System.out.println("Enter books for order using comma without spaces:");
        String userInput = scanner.nextLine();

        if (isEqual(userInput, Actions.STOP)) {
            return true;
        }

        try {
            String[] books = userInput.split(",");
            Order newOrder = service.createNewOrder(books);

            System.out.println(newOrder.getOrderData());
        } catch (NullPointerException exception) {
            System.out.println("Wrong input.");
        }

        return false;
    }

    private static boolean isEqual(String string, Actions action) {
        return action.toString().toLowerCase().equals(string);
    }
}
