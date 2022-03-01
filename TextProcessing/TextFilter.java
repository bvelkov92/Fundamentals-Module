package src.TextProcessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] replasedWords = scanner.nextLine().split(", ");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < replasedWords.length; i++) {
            StringBuilder currentWord = new StringBuilder(replasedWords[i]);
            int lenghtWord = currentWord.length();

            StringBuilder replacer = new StringBuilder();
            for (int j = 0; j < lenghtWord; j++) {
                replacer.append("*");
            }
            for (int j = 0; j < text.length(); j++) {
                int startIndex = text.indexOf(currentWord.toString());
                if (startIndex==-1){
                    break;
                }else {
                    text.replace(startIndex, startIndex + lenghtWord, replacer.toString());
                }

            }
        }
        System.out.println(text.toString());
    }
}

