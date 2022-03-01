package src.TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] text = scanner.nextLine().split(", ");

        for (String currentText : text) {
            boolean forNext = false;
            boolean neededLengh = false;
            StringBuilder sB = new StringBuilder(currentText);
            if (currentText.length() < 3 ||  currentText.length() > 16) {
                neededLengh = true;
            }
            if (!neededLengh){
                for (int j = 0; j < currentText.length(); j++) {
                    char symbol = currentText.charAt(j);
                    if (!(symbol == '-' || symbol == '_' || Character.isLetterOrDigit(symbol))) {
                        forNext = true;
                        break;
                    }
                }
                }
            if (!forNext && !neededLengh){
                System.out.println(sB);
            }
        }

    }
}
