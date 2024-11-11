import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Order;
import utils.DateFormatter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    Order order;
    BigDecimal price = new BigDecimal(50);
    String[] books = {"Harry Potter", "The catcher in the rye", "To kill a mockingbird", "The hobbit", "Don Quixote"};
    String formattedDate = DateFormatter.formatDate(LocalDateTime.now());
    int orderNumber;

    @BeforeEach
    void setUp() {
        orderNumber += 1;
        order = new Order(price, books, orderNumber);
    }
    @Test
    void getOrderData() {
        String result = order.getOrderData();
        String expected = String.format(
                "Order with No. %d created on %s for books - %s - with total price %s",
                orderNumber, formattedDate, Arrays.toString(books), price
        );

        assertEquals(expected, result);
    }

    @Test
    void getOrderNumber () throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = Order.class.getDeclaredMethod("getOrderNumber");

        privateMethod.setAccessible(true);

        int result = (int) privateMethod.invoke(order);

        assertEquals(orderNumber, result);
    }

    @Test
    void getOrderDateAsString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = Order.class.getDeclaredMethod("getOrderDateAsString");

        privateMethod.setAccessible(true);

        String result = (String) privateMethod.invoke(order);

        assertEquals(formattedDate, result);
    }

    @Test
    void getOrderedBooks() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = Order.class.getDeclaredMethod("getOrderedBooks");

        privateMethod.setAccessible(true);

        String[] result = (String[]) privateMethod.invoke(order);

        assertEquals(Arrays.toString(books), Arrays.toString(result));
    }

    @Test
    void getTotalPrice() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = Order.class.getDeclaredMethod("getTotalPrice");

        privateMethod.setAccessible(true);

        BigDecimal result = (BigDecimal) privateMethod.invoke(order);

        assertEquals(price, result);
    }
}
