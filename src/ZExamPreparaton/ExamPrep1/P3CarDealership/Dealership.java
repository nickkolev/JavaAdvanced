package ZExamPreparaton.ExamPrep1.P3CarDealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> cars;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Car car) {
        if(cars.size() < capacity) {
            cars.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : cars) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                cars.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if(cars.size() > 0) {
            cars.sort(Comparator.comparingInt(Car::getYear));
            return cars.get(0);
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : cars) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return cars.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output
                .append(" The cars are in a car dealership ")
                .append(this.getName())
                .append(":");
        this.cars
                .forEach(car -> output.append(System.lineSeparator()).append(car));
        return output.toString();
    }
}
