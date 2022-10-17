package L04StreamsFilesAndDirectories.exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P6WordCount {
    public static void main(String[] args) {
        //1. прочитаме думите, които ще търсим
        //2. прочитаме дума по дума втория файл
        //3. записваме резултата на няколко реда в трети файл
        try (Scanner scan = new Scanner(new FileReader("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
             Scanner textScanner = new Scanner(new FileReader("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
             PrintWriter printWriter = new PrintWriter("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt")) {

            LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
            Arrays.stream(scan.nextLine().split(" ")).forEach(word -> wordMap.put(word, 0));

            while (textScanner.hasNext()) {
                String textInput = textScanner.next();
                if (wordMap.containsKey(textInput)) {
                    int occurrences = wordMap.get(textInput);
                    occurrences++;
                    wordMap.put(textInput, occurrences);
                }
            }
            wordMap.entrySet().forEach(entry -> printWriter.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
