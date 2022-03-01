package src.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> isUpperLetter = l -> Character.isUpperCase(l.charAt(0));

        List<String> finallyArr = input.stream().filter(isUpperLetter).collect(Collectors.toList());
        System.out.println(finallyArr.size());
        String finalOutput = finallyArr.stream().collect(Collectors.joining("\n"));
        System.out.println(finalOutput);
    }
}
