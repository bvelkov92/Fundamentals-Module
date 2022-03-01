package src.StreamAPIExercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\input.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\Answers\\ansAllCapitals.txt";

        PrintWriter output = new PrintWriter(pathOut);
        List<String> list = Files.readAllLines(Path.of(pathIn));

        for (String elem : list) {
                String newSymbol = elem.toUpperCase();
                output.write(newSymbol);
                output.println();
        }
        output.close();
    }
}
