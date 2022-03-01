package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;


public class CustomMinFunction {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Consumer<Integer> minNumber = System.out::println;

        String [] number = scanner.nextLine().split("\\s+");
        Arrays.stream(number).mapToInt(Integer::parseInt).min().stream().boxed().forEach(minNumber);

    }
}
