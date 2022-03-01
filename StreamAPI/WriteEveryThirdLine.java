package src.StreamAPI;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\input.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\05.WriteEveryThirdLineOutput.txt";

         Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter outputFile = new PrintWriter(new FileOutputStream(pathOut));
        int counter =1;
        String row = scanner.nextLine();
        while (scanner.hasNextLine()){
            if (counter%3==0){
                outputFile.println(row);
            }
            counter++;
            row= scanner.nextLine();
        }
        outputFile.close();
    }
}
