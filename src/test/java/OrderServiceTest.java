import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Order;
import service.OrderService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    OrderService service = new OrderService();
    String[] books = {"Harry Potter", "The catcher in the rye", "To kill a mockingbird", "The hobbit", "Don Quixote"};
    String input = "Harry Potter,The catcher in the rye,To kill a mockingbird,The hobbit,Don Quixote";
    BigDecimal price = new BigDecimal(books.length);
    Order expectedOrder;
    Scanner scanner;
    int orderCounter = 1;

    @BeforeEach
    void setUp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setOrdersCounter = OrderService.class.getDeclaredMethod("setOrdersCounter", int.class);

        setOrdersCounter.setAccessible(true);
        setOrdersCounter.invoke(service, 0);

        scanner = mock(Scanner.class);
        expectedOrder = new Order(price, books, orderCounter);
    }

    @Test
    void placeBooksOrder() {
        when(scanner.nextLine()).thenReturn(input);

        Order order = service.placeBooksOrder(scanner);

        assertEquals(order.getOrderData(), expectedOrder.getOrderData());
    }

    @Test
    void createNewOrder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = OrderService.class.getDeclaredMethod("createNewOrder", String[].class);

        privateMethod.setAccessible(true);

        Order result = (Order) privateMethod.invoke(service, (Object) books);

        assertEquals(result.getOrderData(), expectedOrder.getOrderData());
    }

    @Test
    void getOrdersCounter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = OrderService.class.getDeclaredMethod("getOrdersCounter");

        privateMethod.setAccessible(true);

        int result = (int) privateMethod.invoke(service);

        assertEquals(result, 0);
    }

    @Test
    void setOrdersCounter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int testValue = 155;
        Method setOrdersCounter = OrderService.class.getDeclaredMethod("setOrdersCounter", int.class);
        Method getOrdersCounter = OrderService.class.getDeclaredMethod("getOrdersCounter");

        setOrdersCounter.setAccessible(true);
        getOrdersCounter.setAccessible(true);
        setOrdersCounter.invoke(service, testValue);

        int result = (int) getOrdersCounter.invoke(service);

        assertEquals(result, testValue);
    }
}
