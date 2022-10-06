package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String currentUrl = "";

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if(input.equals("back")) {
                //back functionality
                if(browserHistory.size() > 1) {
                    browserHistory.pop();
                    currentUrl = browserHistory.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                //url functionality
                browserHistory.push(input);
                currentUrl = browserHistory.peek();
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
