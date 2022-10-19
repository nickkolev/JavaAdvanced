package L05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P4AppliedArithmetics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        // possible commands:
        // "add" -> adds 1;
        UnaryOperator<List<Integer>> add = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        // "multiply" -> multiplies by 2;
        UnaryOperator<List<Integer>> multiply = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        // "subtract" -> subtracts 1;
        UnaryOperator<List<Integer>> subtract = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        // "print" -> prints all numbers on a new line.
        Consumer<List<Integer>> printer = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
                default:
                    System.out.println("NO SUCH COMMAND!");
            }

            command = scanner.nextLine();
        }
    }
}
