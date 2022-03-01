package src.StreamAPIExercises;

import java.io.*;
import java.util.Scanner;

public class LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\inputLineNumbers.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\Answers\\ansLineNumbers";

        PrintWriter output = new PrintWriter(pathOut);
        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        int counter = 1;
        String inputRow = scanner.nextLine();
        while (scanner.hasNextLine()) {
            output.printf("%d. %s%n", counter, inputRow);
            counter++;
            inputRow = scanner.nextLine();
        }
        output.printf("%d. %s%n", counter, inputRow);
        output.close();
    }
}