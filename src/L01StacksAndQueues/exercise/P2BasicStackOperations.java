package L01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P2BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split(" ");

        //pushing n elements into the stack
        ArrayDeque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        //popping S elements from the stack
        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        //check if the number X is in the stack
        if(stack.contains(x)) {
            System.out.println("true");
        } else {
            if(stack.isEmpty()) {
                System.out.println("0");
            } else {
                int minNumber = Collections.min(stack);
                System.out.println(minNumber);
            }
        }
    }
}
