package L05FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getMinNumber = Collections::min;
        System.out.println(getMinNumber.apply(numbers));
    }
}
