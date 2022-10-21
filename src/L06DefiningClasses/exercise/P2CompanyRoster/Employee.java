package L06DefiningClasses.exercise.P2CompanyRoster;

public class Employee {
    //mandatory
    private String name;
    private double salary;
    private String position;
    private String department;

    //optional
    private String email = "n/a";
    private int age = -1;

    //constructor with only the mandatory fields
    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    //constructor with 5 fields - email
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    //constructor with 5 fields - age
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    //constructor with 6 fields
    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department, email);
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
