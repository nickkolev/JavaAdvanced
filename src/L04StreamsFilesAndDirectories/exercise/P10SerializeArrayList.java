package L04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) {
        String path = "D:\\Java\\JavaAdvanced\\src\\L04StreamsFilesAndDirectories\\exercise\\ArrayList.ser";

        List<String> birds = new ArrayList<>();
        birds.add("Vrabche");
        birds.add("Sokol");
        birds.add("Shtarkel");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            oos.writeObject(birds);
            Object listFromFile = ois.readObject();
            System.out.println(listFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
