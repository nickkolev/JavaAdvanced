package L04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P3CopyBytes {
    public static void main(String[] args) {

        String pathIn = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try (FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut)) {

            int oneByte = in.read();
            while(oneByte >= 0) {
                if(oneByte == 32 || oneByte == 10) {
                    out.write((char) oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }

                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}