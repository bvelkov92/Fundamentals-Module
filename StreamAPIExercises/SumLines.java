package src.StreamAPIExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class SumLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\input.txt";
        List<String> list = Files.readAllLines(Path.of(path));
        for (int index = 0; index < list.size(); index++) {
            int counter = 0;
            String symb = list.get(index);
            for (int lenght = 0; lenght < symb.length(); lenght++) {
                counter+=symb.charAt(lenght);
            }
            System.out.println(counter);
        }

    }
}
