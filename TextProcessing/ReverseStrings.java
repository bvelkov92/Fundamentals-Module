package src.TextProcessing;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        while (!text.equals("end")) {

            StringBuilder result = new StringBuilder(text);
            result.reverse();
            System.out.printf("%s = %s%n", text, result);
            text= scanner.nextLine();
        }
    }
}
