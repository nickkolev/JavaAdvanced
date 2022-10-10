package L03SetsAndMapsAdvanced.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P9Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .sorted((left, right) -> right.compareTo(left))
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
