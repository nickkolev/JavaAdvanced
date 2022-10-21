package L06DefiningClasses.exercise.P4RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");

            String model = carInfo[0];

            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < carInfo.length; j = j + 2) {
                double tirePressure = Double.parseDouble(carInfo[j]);
                int tireAge = Integer.parseInt(carInfo[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();
        if (cargoType.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
