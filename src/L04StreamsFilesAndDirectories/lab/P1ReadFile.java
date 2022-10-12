package L04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;

public class P1ReadFile {
    public static void main(String[] args) {

        String path = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(FileInputStream inStream = new FileInputStream(path)) {
            int oneByte = inStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
