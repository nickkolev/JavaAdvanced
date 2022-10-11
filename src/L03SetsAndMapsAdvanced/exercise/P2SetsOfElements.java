package L03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> first = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            first.add(scanner.nextLine());
        }

        Set<String> second = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            second.add(scanner.nextLine());
        }

        first.retainAll(second);

        System.out.println(String.join(" ", first));
    }
}
