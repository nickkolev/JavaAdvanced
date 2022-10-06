package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P6HotPotato {
    public static void main(String[] args) {

        //read the input
        Scanner scanner = new Scanner(System.in);
        String[] players = scanner.nextLine().split(" ");
        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> playersQueue = new ArrayDeque<>();

        //Put the input into a queue
        for (int i = 0; i < players.length; i++) {
            playersQueue.offer(players[i]);
        }

        //implement the logic
        while(playersQueue.size() != 1) {
            for (int i = 1; i < passes; i++) {
                String currentPlayer = playersQueue.poll();
                playersQueue.offer(currentPlayer);
            }
            String playerToRemove = playersQueue.poll();
            System.out.println("Removed " + playerToRemove);
        }
        String lastPlayer = playersQueue.peek();
        System.out.println("Last is " + lastPlayer);
    }
}
