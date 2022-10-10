package L03SetsAndMapsAdvanced.lab;

import java.util.*;

public class P7CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countryWithCities = map.get(continent);
            countryWithCities.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countryWithCities.get(country);
            cities.add(city);
        }

        map.entrySet()
                .forEach(entry -> {
                    String continent = entry.getKey();
                    Map<String, List<String>> countryWithCities = entry.getValue();

                    System.out.println(continent + ":");

                    countryWithCities.entrySet()
                            .forEach(e -> {
                                System.out.println("  " + e.getKey() + " -> " + String.join(", ", e.getValue()));
                            });
                });
    }
}
