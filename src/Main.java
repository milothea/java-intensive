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
        RegisterService registerService = new RegisterService();
        OrderService orderService = new OrderService();
        Scanner input = new Scanner(System.in);
        String action;
        String userInput;

        System.out.println("Enter 'apart' to book an apartment. Enter 'book' to open books' order.");
        System.out.println("Enter 'stop' to quit the app.");

        action = input.nextLine();

        while (action != null && action.equalsIgnoreCase(Actions.APART.toString())) {
            System.out.println("Enter price for apartment reservation:");
            userInput = input.nextLine();

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

        while (action != null && action.equalsIgnoreCase(Actions.BOOK.toString())) {
            System.out.println("Enter books for order using comma without spaces:");
            userInput = input.nextLine();

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
