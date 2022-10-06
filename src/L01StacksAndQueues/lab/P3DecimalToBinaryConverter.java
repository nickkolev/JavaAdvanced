package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P3DecimalToBinaryConverter {
    public static void main(String[] args) {

        //read the input
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //check if the input number is 0
        if(decimal == 0) {
            System.out.println(0);
        } else {
            //calculate the number in decimal
            while(decimal > 0) {
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }
        stack.forEach(System.out::print);
    }
}
