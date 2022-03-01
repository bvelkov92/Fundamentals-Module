package src.TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplayer {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String[ ] text = scanner.nextLine().split(" ");
         String wordOne = text[0];
         String wordTwo = text[1];
        int totalSum = 0;
        String diff = "";
        String lenght ="";

        if (wordOne.length()>wordTwo.length()){
            diff = wordOne.substring(wordTwo.length());
            lenght =wordTwo;
        }else if (wordOne.length()<wordTwo.length()){
            diff = wordTwo.substring(wordOne.length());
            lenght = wordOne;
        }else{
            diff = wordOne;
            lenght=wordTwo;
        }

             for (int i = 0; i < lenght.length(); i++) {
              int characterWordOne = wordOne.charAt(i);
              int characterWordTwo = wordTwo.charAt(i);
              totalSum+=characterWordOne*characterWordTwo;
         }
             if (wordOne.length()==wordTwo.length()){
                 System.out.println(totalSum);
             }else {
                 int diffSum = 0;
                 for (int i = 0; i < diff.length(); i++) {
                     diffSum+= diff.charAt(i);
                 }
                 System.out.println(totalSum+diffSum);
             }
    }

}
