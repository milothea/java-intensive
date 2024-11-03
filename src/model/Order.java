package src.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import src.utils.DateFormatter;

public class Order extends DateFormatter {
    private final int orderNumber;
    private final String[] orderedBooks;
    private final BigDecimal totalPrice;
    private final LocalDateTime orderDate;

    public Order(BigDecimal price, String[] books, int orderNumber) {
        this.orderDate = LocalDateTime.now();
        this.totalPrice = price;
        this.orderedBooks = books;
        this.orderNumber = orderNumber;
    }

    public String getOrderData() {
        LocalDateTime date = this.getOrderDate();
        String[] books = this.getOrderedBooks();
        BigDecimal price = this.getTotalPrice();

        return String.format(
                "Order with No. %d created on %s for books - %s - with total price %s",
                this.getOrderNumber(), this.formatDate(date), Arrays.toString(books), price
        );
    }

    private int getOrderNumber() {
        return this.orderNumber;
    }

    private LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    private String[] getOrderedBooks() {
        return this.orderedBooks;
    }

    private BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
}
