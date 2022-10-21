package L06DefiningClasses.exercise.P3SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            double fuel = Integer.parseInt(input[1]);
            double fuelCostPerKilometer = Double.parseDouble(input[2]);

            Car car = new Car(model, fuel, fuelCostPerKilometer);
            cars.put(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);

            Car currentCar = cars.get(model);
            if (currentCar.hasEnoughFuel(kilometers)) {
                currentCar.drive(kilometers);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
