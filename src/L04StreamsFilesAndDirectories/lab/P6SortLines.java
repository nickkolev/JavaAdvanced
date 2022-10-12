package L04StreamsFilesAndDirectories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P6SortLines {
    public static void main(String[] args) throws IOException {

        Path pathIn = Paths.get("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathOut = Paths.get("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");


        List<String> lines = Files.readAllLines(pathIn);
        Collections.sort(lines);
        Files.write(pathOut, lines);
    }
}
