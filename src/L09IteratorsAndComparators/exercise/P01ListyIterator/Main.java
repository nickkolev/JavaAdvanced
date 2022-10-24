package L09IteratorsAndComparators.exercise.P01ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ListIterator listIterator = null;

        while (!line.equals("END")) {
            String[] commandParts =line.split(" ");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Create":
                    if (commandParts.length > 1) {
                        listIterator = new ListIterator(Arrays
                                .copyOfRange(commandParts, 1, commandParts.length));
                    } else {
                        listIterator = new ListIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        listIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }

                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
            }
            line = scanner.nextLine();
        }
    }
}