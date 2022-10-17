package L04StreamsFilesAndDirectories.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P9CopyAPicture {
    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\image.jpg");
             FileOutputStream fos = new FileOutputStream("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\copyImage.jpg")) {
            while (fis.read(buffer) != -1) {
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
