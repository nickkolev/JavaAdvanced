package L04StreamsFilesAndDirectories.exercise;

import java.io.*;

public class P3ALLCAPITALS {
    public static void main(String[] args) {

        String pathIn = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(pathIn)); PrintWriter pw = new PrintWriter(pathOut)) {

            br.lines().forEach(line -> pw.println(line.toUpperCase()));

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
