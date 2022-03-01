package src.StreamAPIExercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {

        String pathInOne ="C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\inputOne.txt";
        String pathInTwo ="C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\inputTwo.txt";

         Scanner scannerOne = new Scanner(new FileInputStream(pathInOne));
          Scanner scannerTwo = new Scanner(new FileInputStream(pathInTwo));
        FileOutputStream output =
                new FileOutputStream
                        ("C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\Answers\\ansMergeTwoFiles");

        PrintWriter out = new PrintWriter(output);

        String currentText = scannerOne.next();
        forInput(scannerOne, out, currentText);
        currentText = scannerTwo.next();
        forInput(scannerTwo, out, currentText);
        out.close();
    }

    private static void forInput(Scanner scanner, PrintWriter out, String currentText) {
        while (scanner.hasNext()){
            out.println(currentText);
            currentText = scanner.next();
        }
        out.println(currentText);
    }
}
