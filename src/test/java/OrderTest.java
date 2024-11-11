import model.Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.DateFormatter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    Order order;
    BigDecimal price = new BigDecimal(50);
    String formattedDate = DateFormatter.formatDate(LocalDateTime.now());


    static Stream<Arguments> getArguments() {
        List<String> inputs = List.of(
                "Harry Potter",
                "Harry Potter,The catcher in the rye",
                "Harry Potter,The catcher in the rye,To kill a mockingbird",
                "Harry Potter,The catcher in the rye,To kill a mockingbird,The hobbit"
        );

        return IntStream.range(0, inputs.size())
                .mapToObj((index) -> Arguments.arguments(inputs.get(index), index));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void getOrderData(String input, int index) {
        String[] books = input.split(",");
        int orderNumber = index + 1;
        Order order = new Order(price, books, orderNumber);
        String result = order.getOrderData();
        String expected = String.format(
                "Order with No. %d created on %s for books - %s - with total price %s",
                orderNumber, formattedDate, Arrays.toString(books), price
        );

        assertNotNull(order);
        assertEquals(expected, result);
    }
}
