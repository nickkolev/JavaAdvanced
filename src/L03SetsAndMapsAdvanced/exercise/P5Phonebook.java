package L03SetsAndMapsAdvanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P5Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("search")) {
            //Name-PhoneNumber
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];

            //fill the phonebook
            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;

            //if the name is in the phonebook
            if(phonebook.containsKey(name)) {
                String phoneNumber = phonebook.get(name);
                System.out.println(name + " -> " + phoneNumber);
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }

            input = scanner.nextLine();
        }
    }
}
