package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Consumer<String> printName = n-> System.out.println("Sir " +n);
        String[] nameArr = scanner.nextLine().split("\\s+");
        Arrays.stream(nameArr).forEach(printName);
    }
}
