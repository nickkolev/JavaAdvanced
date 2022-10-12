package L04StreamsFilesAndDirectories.lab;

import java.io.File;
import java.util.Arrays;

public class P7ListFiles {
    public static void main(String[] args) {

        File root = new File("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Arrays.stream(root.listFiles(File::isFile))
                .forEach(f -> System.out.println(f.getName() + ": " + "[" + f.length() + "]"));
    }
}
