package L03SetsAndMapsAdvanced.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P6ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsInfo = new TreeMap<>();
        String command = scanner.nextLine();
        while(!command.equals("Revision")) {
            String[] tokens = command.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            shopsInfo.putIfAbsent(shop, new LinkedHashMap<>());
            shopsInfo.get(shop).putIfAbsent(product, price);

            command = scanner.nextLine();
        }

        shopsInfo.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            });
        });
    }
}
