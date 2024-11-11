import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import service.*;
import utils.*;
import constants.Action;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
            Enter 'apart' to book an apartment. Enter 'book' to open books' order. Maximum 5 entries.book
            Enter 'stop' to quit the app.""");

        RegisterService registerService = new RegisterService();
        OrderService orderService = new OrderService();
        Scanner input = new Scanner(System.in);
        String action = input.nextLine();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<ApartmentReservation> reservations = new ArrayList<>();

        do {
            if (StringsComparator.isEqual(action, Action.APART)) {
                ApartmentReservation reservation = registerService.makeApartmentReservation(input);

                if (reservation == null) {
                    action = Action.STOP.toString();
                } else {
                    reservations.add(reservation);
                }
            }

            if (StringsComparator.isEqual(action, Action.BOOK)) {
                Order order = orderService.placeBooksOrder(input);

                if (order == null) {
                    action = Action.STOP.toString();
                } else {
                    orders.add(order);
                }
            }

        } while(!StringsComparator.isEqual(action, Action.STOP));
    }
}
