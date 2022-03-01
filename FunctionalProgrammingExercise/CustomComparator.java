package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         List<Integer> startList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> evenNumbers = n-> n%2==0;
        Predicate<Integer> oddNumbers = n-> n%2!=0;


         List <Integer> evens = startList.stream().filter(evenNumbers).sorted().collect(Collectors.toList());
         List<Integer> lasted = startList.stream().filter(oddNumbers).sorted().collect(Collectors.toList());

        Consumer<Integer> printNumbers = n-> System.out.print(n + " ");

        evens.forEach(printNumbers);
        lasted.forEach(printNumbers);
    }
}
