package L04StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P7MergeTwoFiles {
    public static void main(String[] args) {

        Path inputOne = Paths.get("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path inputTwo = Paths.get("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path output = Paths.get("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        try {
            List<String> firstFile = Files.readAllLines(inputOne);
            List<String> secondFile = Files.readAllLines(inputTwo);
            Files.write(output, firstFile, StandardOpenOption.APPEND);
            Files.write(output, secondFile, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
