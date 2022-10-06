package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P2SimpleCalculator {
    public static void main(String[] args) {

        //read the input
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        //convert the input to a stack
        ArrayDeque<String> tokens = new ArrayDeque<>();
        Collections.addAll(tokens, input);

        //pop 3 elements -> calculate -> repeat until the stack is empty
        while(tokens.size() > 1) {
            int num1 = Integer.parseInt(tokens.pop());
            String sign = tokens.pop();
            int num2 = Integer.parseInt(tokens.pop());

            int result = 0;
            //check if the sign is + or -
            if (sign.equals("+")) {
                result = num1 + num2;
            } else if (sign.equals("-")) {
                result = num1 - num2;
            }
            tokens.push(String.valueOf(result));
        }
        System.out.println(tokens.peek());
    }
}
