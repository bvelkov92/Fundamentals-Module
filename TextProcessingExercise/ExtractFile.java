package src.TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] directory = scanner.nextLine().split("\\\\");

         String [] neededFile = directory[directory.length-1].split("\\.");

        System.out.println("File name: " +neededFile[0]);
        System.out.println("File extension: " +neededFile[1]);

    }
}
