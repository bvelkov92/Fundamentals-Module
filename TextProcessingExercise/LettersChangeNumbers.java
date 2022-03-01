package src.TextProcessingExercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        double result = 0;
        for (int i = 0; i < text.length; i++) {
            String currentWord = text[i];

            char firstLetter = currentWord.charAt(0);
            char lastLetter = currentWord.charAt(currentWord.length() - 1);
            StringBuilder number = new StringBuilder(currentWord);
            number.deleteCharAt(0);
            number.deleteCharAt(number.length() - 1);
            int currentNumber = Integer.parseInt(number.toString());

            //for first letter
            int firstNumber = 0;
            int secondNumber = 0;
            double numberOne = 0;
            if (Character.isUpperCase(firstLetter) && Character.isUpperCase(lastLetter)) {  // UP UP
                firstNumber = firstLetter - 64;
                secondNumber = lastLetter - 64;
                numberOne = (1.0 * currentNumber / firstNumber) - secondNumber;
            } else if (Character.isUpperCase(firstLetter) && Character.isLowerCase(lastLetter)) { // UP LOW
                firstNumber = firstLetter - 64;
                secondNumber = lastLetter - 96;
                numberOne = (1.0 * currentNumber / firstNumber) + secondNumber;
            } else if (Character.isLowerCase(firstLetter) && Character.isLowerCase(lastLetter)) { // LOW LOW
                firstNumber = firstLetter - 96;
                secondNumber = lastLetter - 96;
                numberOne = (1.0 * currentNumber * firstNumber) + secondNumber;
            } else if (Character.isLowerCase(firstLetter) && Character.isUpperCase(lastLetter)) { //LOW UP
                firstNumber = firstLetter - 96;
                secondNumber = lastLetter - 64;
                numberOne = (1.0 * currentNumber * firstNumber) - secondNumber;
            }

            result += numberOne;
        }
        System.out.printf("%.2f", result);
    }
}
