package L03SetsAndMapsAdvanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // symbol --> occurrences
        Map<String, Integer> occurrences = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            //Get the current char
            String current = String.valueOf(input.charAt(i));

            //If the char is not present in the Map
            if(!occurrences.containsKey(current)){
                occurrences.put(current, 1);
            }
            //If the char is already in the Map
            else {
                int currentOccurrences = occurrences.get(current);
                occurrences.put(current, currentOccurrences + 1);
            }
        }

        //print -> {char}: {occurrences} time/s
        occurrences.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
