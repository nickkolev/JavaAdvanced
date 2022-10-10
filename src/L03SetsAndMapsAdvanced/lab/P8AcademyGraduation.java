package L03SetsAndMapsAdvanced.lab;

import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P8AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String Student = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toCollection(ArrayList<Double>::new));

            studentsGrades.putIfAbsent(Student, grades);
        }

        studentsGrades.forEach((key, value) -> {
            double sum = 0;

            for (Double grade : value) {
                sum += grade;
            }

            double average = sum / value.size();

            System.out.printf("%s is graduated with %s%n", key, average);
        });
    }
}
