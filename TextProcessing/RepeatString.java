package src.TextProcessing;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] input = scanner.nextLine().split("\\s+");

        for (String s : input) {
            StringBuilder currentWord = new StringBuilder(s);
            for (int j = 0; j < currentWord.length(); j++) {
                System.out.print(currentWord);
            }

        }
    }
}
