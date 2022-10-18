package L05FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        //print the count of the numbers
        Function<int[], String> countFormatter = arr -> "Count = " + arr.length;
        String countOutput = countFormatter.apply(numbers);
        System.out.println(countOutput);

        System.out.println("Sum = " + Arrays.stream(numbers).sum());
    }
}
