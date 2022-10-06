package L01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1ReverseNumbersWithAStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //read the numbers and put them in an array
        String[] numbers = scanner.nextLine().split(" ");

        //put the numbers into a stack
        ArrayDeque<String> numbersStack = new ArrayDeque<>();
        for (String number : numbers) {
            numbersStack.push(number);
        }

        //reverse the numbers in the stack
        while(!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }

    }
}
