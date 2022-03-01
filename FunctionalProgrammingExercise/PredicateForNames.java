package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int lengths = Integer.parseInt(scanner.nextLine());
        String [] names = scanner.nextLine().split("\\s+");
        Predicate<String> wordLength = l->l.length()<= lengths;
        Consumer<String> printWords= System.out::println;
        Arrays.stream(names).filter(wordLength).forEach(printWords);
    }
}
