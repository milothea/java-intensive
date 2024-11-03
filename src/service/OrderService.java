package src.service;

import src.model.Order;

import java.math.BigDecimal;

public class OrderService {
    private static int ordersCounter = 0;
    public OrderService () {}

    public Order createNewOrder (String[] books) {
        BigDecimal price = new BigDecimal(books.length);
        int orderNumber = this.getOrdersCounter() + 1;
        this.setOrdersCounter(orderNumber);

        return new Order(price, books, orderNumber);

    }

    private int getOrdersCounter() {
        return this.ordersCounter;
    }

    private void setOrdersCounter(int value) {
        this.ordersCounter = value;
    }
}
