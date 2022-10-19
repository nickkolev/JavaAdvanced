package L05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P7FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        //начин 1 -> Function която връща най-десният индекс на най-малкия елемент
        Function<List<Integer>, Integer> smallestNumber = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(smallestNumber.apply(numbers));

        //начин 2 -> Consumer, който принтира индексът на най-малкия елемент
        //Consumer<List<Integer>> printIndexOfSmallestElements = list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        //printIndexOfSmallestElements.accept(numbers);
    }
}
