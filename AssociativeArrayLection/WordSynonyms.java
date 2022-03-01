package src.AssociativeArrayLection;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int numberWords = Integer.parseInt(scanner.nextLine());
        Map<String, String> wordList = new LinkedHashMap<>();

        for (int i = 0; i < numberWords; i++) {

            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordList.containsKey(key)){
                wordList.put(key, synonym);
            }else{
                wordList.put(key, wordList.get(key) + ", " +synonym);
            }
        }
        for (Map.Entry<String, String> item : wordList.entrySet()) {
            System.out.printf("%s - %s%n", item.getKey(),item.getValue());
        }

    }
}
