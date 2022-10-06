package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P8BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backBrowserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardBrowserHistory = new ArrayDeque<>();
        String currentUrl = "";

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if(input.equals("back")) {
                //back functionality
                if(backBrowserHistory.size() > 1) {
                    forwardBrowserHistory.addFirst(backBrowserHistory.pop());
                    currentUrl = backBrowserHistory.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if(forwardBrowserHistory.size() >= 1) {
                    currentUrl = forwardBrowserHistory.pop();
                    backBrowserHistory.push(currentUrl);
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                //url functionality
                backBrowserHistory.push(input);
                currentUrl = input;
                forwardBrowserHistory.clear();
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
