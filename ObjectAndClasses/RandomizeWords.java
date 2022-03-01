package src.ObjectAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sentenceArray = scanner.nextLine().split("\\s+");
        Random randomGenerator = new Random();
        for (int index = 0; index < sentenceArray.length; index++) {

            int randomIndexA = randomGenerator.nextInt(sentenceArray.length);
            int randomIndexB = randomGenerator.nextInt(sentenceArray.length);

            String currentWord = sentenceArray[randomIndexA];
            sentenceArray[randomIndexA] = sentenceArray[randomIndexB];
            sentenceArray[randomIndexB] = currentWord;


        }

        System.out.println(String.join(System.lineSeparator(), sentenceArray));
    }
}
