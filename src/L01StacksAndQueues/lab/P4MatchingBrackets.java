package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P4MatchingBrackets {
    public static void main(String[] args) {

        //read the input
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //scan through the expression -> subtract separate expressions
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if(current == '(') {
                stack.push(i);
            } else if (current == ')') {
                int startIndex = stack.pop();
                String content = expression.substring(startIndex, i + 1);
                System.out.println(content);
            }
        }
    }
}
