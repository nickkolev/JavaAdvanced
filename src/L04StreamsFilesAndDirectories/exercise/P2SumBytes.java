package L04StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P2SumBytes {
    public static void main(String[] args) {

        String path = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            long sum = 0;
            String line = br.readLine();

            while(line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentSymbol = line.charAt(i);
                    sum += currentSymbol;
                }

                line = br.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
