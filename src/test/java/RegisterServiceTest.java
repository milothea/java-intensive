import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import service.RegisterService;
import model.ApartmentReservation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RegisterServiceTest {

    RegisterService service = new RegisterService();
    Scanner scanner;

    @BeforeEach
    void setUp() {
        scanner = mock(Scanner.class);
    }

    static Stream<Arguments> getArguments() {
        List<String> inputs = List.of("10", "20", "30", "40");

        return IntStream.range(0, inputs.size())
                .mapToObj((index) -> Arguments.arguments(inputs.get(index), index));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void makeApartmentReservation(String input, int index) {
        when(scanner.nextLine()).thenReturn(input);

        BigDecimal price = new BigDecimal(input);
        ApartmentReservation reservation = service.makeApartmentReservation(scanner);
        ApartmentReservation expectedReservation = new ApartmentReservation(price, index + 1);

        assertNotNull(reservation);
        assertEquals(reservation.getReservationData(), expectedReservation.getReservationData());
    }
}
