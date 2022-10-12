package L03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //Country -> citi -> population
        //        -> city -> population

        //Map<String, Map<String, Integer>>
        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        while (!input.equals("report")) {
            //read the input
            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countries.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    long p1 = c1.getValue().values().stream().mapToLong(l -> l).sum();
                    long p2 = c2.getValue().values().stream().mapToLong(l -> l).sum();
                    return Long.compare(p2, p1);
                })
                .forEach(c -> {
                    long totalPopulation = c.getValue().values().stream().mapToLong(Long::longValue).sum();

                    System.out.printf("%s (total population: %d)%n", c.getKey(), totalPopulation);

                    LinkedHashMap<String, Long> cityInfo = c.getValue();
                    cityInfo.entrySet().stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
