package service;

import constants.Action;
import model.Order;
import utils.StringsComparator;

import java.math.BigDecimal;
import java.util.Scanner;

public class OrderService {
    private static int ORDERS_COUNTER;
    public OrderService () {}

    public Order placeBooksOrder(Scanner scanner) {
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

    private Order createNewOrder (String[] books) {
        BigDecimal price = new BigDecimal(books.length);
        int orderNumber = getOrdersCounter() + 1;

        setOrdersCounter(orderNumber);

        return new Order(price, books, orderNumber);
    }

    private int getOrdersCounter() {
        return ORDERS_COUNTER;
    }

    private void setOrdersCounter(int value) {
        ORDERS_COUNTER = value;
    }
}
