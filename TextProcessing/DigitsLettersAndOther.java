package src.TextProcessing;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         StringBuilder text = new StringBuilder(scanner.nextLine());
         StringBuilder numbers = new StringBuilder();
         StringBuilder letters = new StringBuilder();
         StringBuilder others = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if(Character.isDigit(symbol)){
                numbers.append(symbol);
            }else if(Character.isLetter(symbol)){
                letters.append(symbol);
            }else {
                others.append(symbol);
            }
        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(others);
    }
}
