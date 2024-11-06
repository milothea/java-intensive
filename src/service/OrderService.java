package src.service;

import src.constants.Action;
import src.model.Order;
import src.utils.StringsComparator;

import java.math.BigDecimal;
import java.util.Scanner;

public class OrderService {
    private static int ORDERS_COUNTER;
    public OrderService () {}

    public static Order placeBooksOrder(Scanner scanner) {
        System.out.println("Enter books for order using comma without spaces:");
        String userInput = scanner.nextLine();

        if (!StringsComparator.isEqual(userInput, Action.STOP)) {
            try {
                String[] books = userInput.split(",");
                Order order = createNewOrder(books);

                System.out.println(order.getOrderData());

                return order;
            } catch (NullPointerException exception) {
                System.out.println("Wrong input.");
            }
        }

        return null;
    }

    private static Order createNewOrder (String[] books) {
        BigDecimal price = new BigDecimal(books.length);
        int orderNumber = getOrdersCounter() + 1;

        setOrdersCounter(orderNumber);

        return new Order(price, books, orderNumber);
    }

    private static int getOrdersCounter() {
        return ORDERS_COUNTER;
    }

    private static void setOrdersCounter(int value) {
        ORDERS_COUNTER = value;
    }
}
