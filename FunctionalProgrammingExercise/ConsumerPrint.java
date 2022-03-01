package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class ConsumerPrint {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Consumer<String> printList = System.out::println;

        List<String> inputList =Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
                inputList.forEach(printList);
    }
}
