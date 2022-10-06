package L01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P5PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //create a queue to put the files in there
        ArrayDeque<String> filesQueue = new ArrayDeque<>();

        //read commands while receiving "print"
        String input = scanner.nextLine();
        while (!input.equals("print")) {

            //If the command is "cancel" -> remove the file from the queue (the first file to be printed)
            if(input.equals("cancel")) {
                //If there is no file to be canceled -> print "Printer is on standby"
                if(filesQueue.size() < 1) {
                    System.out.println("Printer is on standby");
                } else {
                    // -> print "Canceled filename.txt"
                    String removed = filesQueue.poll();
                    System.out.println("Canceled " + removed);
                }
            } else {
                //If the command is a name of file -> add it to the queue
                filesQueue.offer(input);
            }

            input = scanner.nextLine();
        }
        //When the command is "print" -> print the filenames in the order of printing
        filesQueue.forEach(System.out::println);
    }
}
