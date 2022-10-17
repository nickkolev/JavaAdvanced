package L04StreamsFilesAndDirectories.exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P4CountCharacterTypes {
    public static void main(String[] args) {

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileReader fileReader = new FileReader("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
             PrintWriter printWriter = new PrintWriter("D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt")) {
            int oneSymbol = fileReader.read();
            while (oneSymbol >= 0) {
                char symbolAsChar = (char) oneSymbol;
                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuation++;
                } else if (!Character.isWhitespace(symbolAsChar) /*&& !Character.isDigit(symbolAsChar)*/) {
                    consonants++;
                }
                oneSymbol = fileReader.read();
            }
            printWriter.println("Vowels: " + vowels);
            printWriter.println("Other symbols: " + consonants);
            printWriter.println("Punctuation: " + punctuation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isVowel(char character) {
        return character == 'a' || character == 'o' || character == 'u' || character == 'e' || character == 'i';
    }

    public static boolean isPunctuation(char character) {
        return character == '!' || character == ',' || character == '.' || character == '?';
    }
}
