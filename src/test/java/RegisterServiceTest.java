import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RegisterService;
import model.ApartmentReservation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RegisterServiceTest {
    BigDecimal price = new BigDecimal(150);
    RegisterService service = new RegisterService();
    ApartmentReservation expectedReservation;
    Scanner scanner;
    int apartmentNumber = 1;

    @BeforeEach
    void setUp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setCounter = RegisterService.class.getDeclaredMethod("setCounter", int.class);

        setCounter.setAccessible(true);
        setCounter.invoke(service, 0);
        expectedReservation = new ApartmentReservation(price, apartmentNumber);
        scanner = mock(Scanner.class);
    }

    @Test
    void makeApartmentReservation() {
        when(scanner.nextLine()).thenReturn(price.toString());

        ApartmentReservation reservation = service.makeApartmentReservation(scanner);

        assertEquals(reservation.getReservationData(), expectedReservation.getReservationData());
    }

    @Test
    void registerApartment() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method registerApartment = RegisterService.class.getDeclaredMethod("registerApartment", BigDecimal.class);

        registerApartment.setAccessible(true);
        ApartmentReservation reservation = (ApartmentReservation) registerApartment.invoke(service, price);

        assertEquals(reservation.getReservationData(), expectedReservation.getReservationData());
    }

    @Test
    void getCounter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getCounter = RegisterService.class.getDeclaredMethod("getCounter");

        getCounter.setAccessible(true);
        int result = (int) getCounter.invoke(service);

        assertEquals(result, 0);
    }

    @Test
    void setCounter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int inputValue = 100500;
        Method setCounter = RegisterService.class.getDeclaredMethod("setCounter", int.class);
        Method getCounter = RegisterService.class.getDeclaredMethod("getCounter");

        setCounter.setAccessible(true);
        getCounter.setAccessible(true);
        setCounter.invoke(service, inputValue);

        int result = (int) getCounter.invoke(service);

        assertEquals(result, inputValue);
    }
}
