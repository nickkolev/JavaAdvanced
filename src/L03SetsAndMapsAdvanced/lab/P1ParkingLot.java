package L03SetsAndMapsAdvanced.lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P1ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split(", ");
            String directions = tokens[0];
            String carRegistration = tokens[1];

            if(directions.equals("IN")) {
                cars.add(carRegistration);
            } else if(directions.equals("OUT")) {
                cars.remove(carRegistration);
            }

            command = scanner.nextLine();
        }

        if(cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(System.out::println);
        }
    }
}
