package src.SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> wordList = new LinkedHashSet<>();
        int number = Integer.parseInt(scanner.nextLine());
        while (number>0){
            String currentWord = scanner.nextLine();
            wordList.add(currentWord);
            number--;
        }
        wordList.forEach(System.out::println);
    }
}
