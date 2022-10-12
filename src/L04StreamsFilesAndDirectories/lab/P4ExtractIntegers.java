package L04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P4ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        FileInputStream in = new FileInputStream(pathIn);

        Scanner reader = new Scanner(in);

        PrintWriter writer = new PrintWriter(pathOut);

        while (reader.hasNext()) {
            if(reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }
            reader.next();
        }
        writer.close();
    }
}
