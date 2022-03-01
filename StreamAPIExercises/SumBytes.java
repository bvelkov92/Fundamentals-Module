package src.StreamAPIExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        String path = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\input.txt";
        List<String> list = Files.readAllLines(Path.of(path));
        for (String symb : list) {
            for (int lenght = 0; lenght < symb.length(); lenght++) {
                counter += symb.charAt(lenght);
            }
        }
        System.out.println(counter);
    }
}
