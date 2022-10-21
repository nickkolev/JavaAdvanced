package L06DefiningClasses.exercise.P3SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCostPerKilometer;
    private int distance;

    public Car(String model, double fuel, double fuelCostPerKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distance = 0;
    }

    public boolean hasEnoughFuel(int kilometers) {
        double fuelNeeded = kilometers * fuelCostPerKilometer;
        return fuel >= fuelNeeded;
    }

    public void drive(int kilometers) {
        double fuelNeeded = kilometers * fuelCostPerKilometer;
        fuel -= fuelNeeded;
        distance += kilometers;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", model, fuel, distance);
    }
}
