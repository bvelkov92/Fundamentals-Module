package src.TextProcessing;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String deleter = scanner.nextLine();
         StringBuilder word = new StringBuilder(scanner.nextLine());
         boolean isEnd = false;

        while (!isEnd) {
            int startIndex = word.indexOf(deleter);
            if (startIndex>-1){
               int deleteIndexes=deleter.length();
                for (int i = startIndex; i <startIndex+deleteIndexes; i++) {
                    word.deleteCharAt(i);
                    deleteIndexes--;
                    i--;
                }
            }
            else{
                isEnd = true;
            }
        }
        System.out.println(word);
    }
}
