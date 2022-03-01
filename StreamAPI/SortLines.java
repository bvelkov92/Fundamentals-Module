package src.StreamAPI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;


public class SortLines {
    public static void main(String[] args) throws IOException {
        Path pathIn = Paths.get("C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\input.txt");
        Path pathOut = Paths.get("C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\06.SortLinesOutput.txt");
        List<String> outputList = Files.readAllLines(pathIn);
        Collections.sort(outputList);
        Files.write(pathOut,outputList);
    }
}
