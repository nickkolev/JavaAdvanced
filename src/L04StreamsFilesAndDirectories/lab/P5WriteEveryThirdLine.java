package L04StreamsFilesAndDirectories.lab;

import java.io.*;

public class P5WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String pathIn = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader in = new BufferedReader(new FileReader(pathIn));

        PrintWriter out = new PrintWriter(pathOut);

        int counter = 1;

        String line = in.readLine();
        while(line != null) {

            if(counter % 3 == 0) {
                out.println(line);
            }

            counter++;
            line = in.readLine();
        }
        out.close();
    }
}
