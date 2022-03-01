package src.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());  //Input

        System.out.println("Count = " +input.size());
        int sum = input.stream().mapToInt(Integer::parseInt).sum();
        System.out.println("Sum = " + sum);
    }
}
