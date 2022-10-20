package L06DefiningClasses.lab.P1CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car(brand, model, horsePower);

            carList.add(car);
            System.out.println(car.carInfo());
        }
    }
}
