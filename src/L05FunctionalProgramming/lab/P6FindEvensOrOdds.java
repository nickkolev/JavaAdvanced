package L05FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P6FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lower = range[0];
        int upper = range[1];

        String type = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            numbers.add(i);
        }

        numbers.stream()
                .filter(getPredicate(type))
                .map(String::valueOf)
                .forEach(e -> System.out.print(e + " "));

        /*
        System.out.println(IntStream.rangeClosed(low, up)
                .boxed()
                .filter(getPredicate(condition))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
         */
    }

    public static Predicate<Integer> getPredicate(String condition) {
        if (condition.equals("even")) {
            return n -> n % 2 == 0;
        }
        return n -> n % 2 != 0;
    }
}
