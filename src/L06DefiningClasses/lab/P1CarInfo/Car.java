package L06DefiningClasses.lab.P1CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    //Constructor that takes only the brand
    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    //Full constructor
    public Car(String brand, String model, int horsepower) {
        this(brand, model);
        this.horsepower = horsepower;
    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
        this.horsepower = -1;
    }

    public Car(String brand, int horsepower) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = horsepower;
    }

    //Getter and Setter for Brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //Getter and Setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //Getter and Setter for horsePower
    public int getHorsePower() {
        return horsepower;
    }

    public void setHorsePower(int horsepower) {
        this.horsepower = horsepower;
    }

    //Print car info
    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                getBrand(),
                getModel(),
                getHorsePower());
    }

    //Overriding the toString method
    @Override
    public String toString() {
        return carInfo();
    }
}
