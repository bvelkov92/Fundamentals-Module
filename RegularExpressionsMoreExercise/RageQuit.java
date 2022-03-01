package src.RegularExpressionsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        String regexForText = "(?<text>[A-z\\W]*)[0-9]+";
        String regexForNumber = "[0-9]+";
        Pattern patternForText = Pattern.compile(regexForText);
        Pattern patternForNumber = Pattern.compile(regexForNumber);
        StringBuilder finalText = new StringBuilder();
        Matcher matcher = null;
        int lastIndex = 0;
        int endIndex;
        Matcher matcher1 = patternForText.matcher(text);
       Matcher matcher2 = patternForNumber.matcher(text);
        StringBuilder finalCurrentText = new StringBuilder();
while (matcher1.find() && matcher2.find()){
    String currentNumber = matcher2.group();
    String currentText = matcher1.group("text");

            char endSymbol;
            if (currentNumber.length() > 1) {
                endIndex = currentNumber.length() - 1;
                endSymbol = currentNumber.charAt(endIndex);
            } else {
                endIndex = text.indexOf(currentNumber);
                endSymbol = currentNumber.charAt(0);
            }
            String newText = currentText.repeat(Integer.parseInt(currentNumber));
            newText = newText.toUpperCase();
            lastIndex = endIndex;
            finalCurrentText.append(newText);
            text.delete(lastIndex,endIndex);
        }
        List<Character> usedSymbolCounter = new ArrayList<>();
        for (int i = 0; i < finalCurrentText.length(); i++) {
            char symbol = finalCurrentText.charAt(i);
            if (!usedSymbolCounter.contains(symbol)) {
                usedSymbolCounter.add(symbol);
            }
        }
        System.out.printf("Unique symbols used: %d%n%s", usedSymbolCounter.size(),finalCurrentText);

    }
}
