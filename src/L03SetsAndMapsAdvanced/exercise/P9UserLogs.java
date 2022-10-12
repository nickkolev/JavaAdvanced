package L03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P9UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input:
        //"IP={IP.Address} message={A&sample&message} user={username}"

        //  User  ->   IP   ->  count
        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");

            String ip = tokens[0].split("=")[1];
            String message = tokens[1].split("=")[1];
            String username = tokens[2].split("=")[1];

            //fill the map
            if(!userLogs.containsKey(username)) {
                userLogs.put(username, new LinkedHashMap<>());
            }

            if(!userLogs.get(username).containsKey(ip)) {
                userLogs.get(username).put(ip, 1);
            } else {
                int newCount = userLogs.get(username).get(ip) + 1;
                userLogs.get(username).put(ip, newCount);
            }

            input = scanner.nextLine();
        }

        for (var attacker : userLogs.entrySet()) {
            System.out.printf("%s:%n", attacker.getKey());
            LinkedHashMap<String, Integer> attacks = attacker.getValue();
            StringBuilder sb = new StringBuilder();

            for (var singleIpAttack : attacks.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", singleIpAttack.getKey(), singleIpAttack.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";

            System.out.println(finalOutput);
        }
    }
}
