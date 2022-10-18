package L05FunctionalProgramming.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P5FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            people.put(name, age);
        }

        String condition = scanner.nextLine(); //younger or older
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine(); //name, age or name age

        //filter people -> only younger/older people
        //Predicate
        BiPredicate<Integer, Integer> filterPredicate;
        if(condition.equals("younger")) {
            filterPredicate = (age, limit) -> age <= limit;
        } else {
            filterPredicate = (age, limit) -> age >= limit;
        }

        //print people -> name, age or name and age
        //Consumer
        Consumer<Map.Entry<String, Integer>> printConsumer;
        if(printType.equals("name")) {
            printConsumer = p -> System.out.println(p.getKey());
        } else if (printType.equals("age")) {
            printConsumer = p -> System.out.println(p.getValue());
        } else {
            printConsumer = p -> System.out.println(p.getKey() + " - " + p.getValue());
        }

        people.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageLimit))
                .forEach(printConsumer);
    }
}
