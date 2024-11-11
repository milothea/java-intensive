import org.junit.jupiter.api.BeforeEach;

import model.Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.OrderService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    OrderService service = new OrderService();
    Scanner scanner;

    @BeforeEach
    void setUp() {
        scanner = mock(Scanner.class);
    }

    static Stream<Arguments> getArguments() {
        List<String> inputs = List.of(
                "Harry Potter,The catcher in the rye,To kill a mockingbird,The hobbit,Don Quixote",
                "some,random,words",
                "test"
        );

        return IntStream.range(0, inputs.size())
                .mapToObj((index) -> Arguments.arguments(inputs.get(index), index));
    }

    @ParameterizedTest(name = "create orders with different inputs")
    @MethodSource("getArguments")
    void placeBooksOrder(String input, int index) {
        when(scanner.nextLine()).thenReturn(input);

        String[] books = input.split(",");
        BigDecimal price = new BigDecimal(books.length);

        Order expectedOrder = new Order(price, books, index + 1);
        Order order = service.placeBooksOrder(scanner);

        assertEquals(order.getOrderData(), expectedOrder.getOrderData());
    }
}
