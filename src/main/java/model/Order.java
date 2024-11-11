package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import utils.DateFormatter;

public class Order {
    private int orderNumber;
    private String[] orderedBooks;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

    public Order(BigDecimal price, String[] books, int orderNumber) {
        this.orderDate = LocalDateTime.now();
        this.totalPrice = price;
        this.orderedBooks = books;
        this.orderNumber = orderNumber;
    }

    public String getOrderData() {
        String date = this.getOrderDateAsString();
        String[] books = this.getOrderedBooks();
        BigDecimal price = this.getTotalPrice();

        return String.format(
                "Order with No. %d created on %s for books - %s - with total price %s",
                this.getOrderNumber(), date, Arrays.toString(books), price
        );
    }

    private int getOrderNumber() {
        return this.orderNumber;
    }

    private String getOrderDateAsString() {
        return DateFormatter.formatDate(this.orderDate);
    }

    private String[] getOrderedBooks() {
        return this.orderedBooks;
    }

    private BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
}
