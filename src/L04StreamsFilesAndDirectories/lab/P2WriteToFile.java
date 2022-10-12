package L04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class P2WriteToFile {
    public static void main(String[] args) {

        String path = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(FileInputStream inStream = new FileInputStream(path);
            FileOutputStream outStream = new FileOutputStream("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt")) {

            int read = inStream.read();

            Set<Character> punctuations = Set.of(',', '.', '!', '?');

            while (read != -1) {

                if (!punctuations.contains((char) read)) {
                    outStream.write(read);
                }
                read = inStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
