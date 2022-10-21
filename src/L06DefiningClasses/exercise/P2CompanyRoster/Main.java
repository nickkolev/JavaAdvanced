package L06DefiningClasses.exercise.P2CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //мап отдел - списък с работници
        Map<String, List<Employee>> departments  = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            //инициализираме напият Employee обект
            Employee employee = null;
            //създаваме нашият обект Employee според броя на входните данни
            if(input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 5) {
                if(input[4].contains("@")) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            //Ако нямаме работник в отдела, създаваме нов списък с работници към този отдел
            if(!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
            }
            //Добавяме нашият работник в съответния отдел, в който работи
            departments.get(department).add(employee);
        }

        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparing(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);

        List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);

        employeeList.forEach(System.out::println);
    }

    public static double getAverageSalary(List<Employee> employees) {
        double sum = 0;

        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        return sum / employees.size();
    }
}
