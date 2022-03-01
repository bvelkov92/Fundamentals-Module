package src.FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Consumer printing = System.out::print;
        Predicate<Integer> evenNumbers = n-> n%2==0;
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());  // Inputed Numbers;

        List<Integer> filteredEvenNumbers = inputList.stream()
                .filter(evenNumbers).collect(Collectors.toList());

      String firstOut =  filteredEvenNumbers
                .stream().map(String::valueOf)
                .collect(Collectors.joining(", "));  // Sorting Evens

        System.out.println(firstOut);  // Print result

        String sortedOut = filteredEvenNumbers.stream().sorted().map(String::valueOf)  //Sorting by high;
                .collect(Collectors.joining(", "));

        System.out.println(sortedOut); //Print sorted Even;



    }
}
