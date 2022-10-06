package L01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P4BasicQueueOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split(" ");

        //pushing n elements into the queue
        ArrayDeque<Integer> queue = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        //remove S elements from the queue
        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        //check if the number X is in the queue
        if(queue.contains(x)) {
            System.out.println("true");
        } else {
            if(queue.isEmpty()) {
                System.out.println("0");
            } else {
                int minNumber = Collections.min(queue);
                System.out.println(minNumber);
            }
        }
    }
}
