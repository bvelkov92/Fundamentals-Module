package src.StreamAPI;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\input.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter output = new PrintWriter(new FileOutputStream(pathOut));
         while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int myNumber = scanner.nextInt();
                output.println(myNumber);
            }
             System.out.println();
            scanner.next();
         }
        output.close();
    }
}
