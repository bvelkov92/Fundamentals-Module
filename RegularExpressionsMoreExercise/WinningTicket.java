package src.RegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] splitetText = text.split(",\\s+");
        for (String currentWords : splitetText) {
            String currentWord =currentWords.trim();
            if (currentWord.length() == 20) {
                String regex = "[@#$^]{6,10}";
                Pattern pattern = Pattern.compile(regex);
                String leftPart = currentWord.substring(0, currentWord.length() / 2);
                String rightPart = currentWord.substring(leftPart.length());
                Matcher matcher1 = pattern.matcher(leftPart);
                String leftNotSortedPart;
                String rightNotSortedPart;
                String sortedLeft="";
                String sortedRight = "";
                if (matcher1.find()) {
                   leftNotSortedPart = matcher1.group();
                     sortedLeft = part(leftNotSortedPart);
                }
                Matcher matcher2 = pattern.matcher(rightPart);
                if (matcher2.find()) {
                    rightNotSortedPart = matcher2.group();
                    sortedRight = part(rightNotSortedPart);
                }
                if (sortedLeft.equals(sortedRight) && sortedLeft.length() == 10) {
                    System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", currentWord
                            , sortedLeft.charAt(0));
                } else if (sortedLeft.length()>=6 && sortedRight.length()>=6) {
                    System.out.printf("ticket \"%s\" - %d%c%n", currentWord, Math.min(sortedLeft.length(), sortedRight.length()), sortedLeft.charAt(0));
                } else {
                    System.out.printf("ticket \"%s\" - no match%n",currentWord);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
    public static String part (String notExtractedSymbols){
        char oldSymbol = notExtractedSymbols.charAt(0);
        StringBuilder extractedSymbols =new StringBuilder();
        for (int j = 0; j < notExtractedSymbols.length(); j++) {
            char symbol = notExtractedSymbols.charAt(j);
            if (oldSymbol!=symbol && extractedSymbols.length()<6){
                extractedSymbols.delete(0,notExtractedSymbols.length());
                extractedSymbols.append(symbol);
                oldSymbol=symbol;
            }else if (oldSymbol != symbol){
                return extractedSymbols.toString();
            }else {
                extractedSymbols.append(symbol);
            }
        }
        return extractedSymbols.toString();
    }
}
