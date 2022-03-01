package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int divisible =Integer.parseInt(scanner.nextLine());

        Predicate<Integer> forPrint = n-> n%divisible==0;

        Collections.reverse(numbers);
        numbers.removeIf(forPrint);

        numbers.forEach(number -> System.out.print(number + " "));


    }
}
