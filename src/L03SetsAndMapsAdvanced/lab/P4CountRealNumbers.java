package L03SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P4CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> map = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(number -> {
                    if(map.containsKey(number)) {
                        int newCount = map.get(number);
                        newCount++;
                        map.put(number, newCount);
                    } else {
                        map.put(number, 1);
                    }
                });

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
