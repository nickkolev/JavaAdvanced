package L03SetsAndMapsAdvanced.lab;

import java.util.*;

public class P5AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);

            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }

        studentsGrades.forEach((key, value) -> {
            double sum = 0;
            for (Double grade : value) {
                sum += grade;
            }
            double avgGrade = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", avgGrade);
        });
    }
}
