package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P7MathPotato {
    public static void main(String[] args) {

        //read the input
        Scanner scanner = new Scanner(System.in);

        //Put the input into a queue
        ArrayDeque<String> playersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(playersQueue::offer);

        int passes = Integer.parseInt(scanner.nextLine());

        //Put the input into a queue
        /*
        String[] players = scanner.nextLine().split(" ");
        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> playersQueue = new ArrayDeque<>();
        for (int i = 0; i < players.length; i++) {
            playersQueue.offer(players[i]);
        }
         */

        int cycles = 1;

        //implement the logic
        while(playersQueue.size() > 1) {
            for (int i = 1; i < passes; i++) {
                String currentPlayer = playersQueue.poll(); // delete first child
                playersQueue.offer(currentPlayer); // put the deleted child behind
            }
            if(isPrime(cycles)) {
                System.out.println("Prime " + playersQueue.peek());
            } else {
                System.out.println("Removed " + playersQueue.poll());
            }
            cycles++;
        }
        System.out.println("Last is " + playersQueue.peek());
    }

    private static boolean isPrime(int number) { // 20=2*10, 4*5 ... 5*4, 10*2 => Math.sqrt(number)
        boolean primeCheck = true;
        if (number == 0 || number == 1) {
            primeCheck = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    primeCheck = false;
                }
            }
        }
        return primeCheck;
    }
}
