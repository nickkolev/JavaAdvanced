package L03SetsAndMapsAdvanced.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P7FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsMap.put(name, email);
            }

            input = scanner.nextLine();
        }

        emailsMap.forEach((key, value) -> {
            System.out.printf("%s -> %s%n", key, value);
        });
    }
}
