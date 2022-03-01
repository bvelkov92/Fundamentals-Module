package src.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FindEvensOrOdds {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int [] borders = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start =borders[0];
        int end = borders[1];
        String condition = scanner.nextLine();

        Predicate<Integer> isEven = n ->
                condition.equals("even") == (n % 2 == 0);

        System.out.println(IntStream.rangeClosed(start,end).boxed().filter(isEven)
                .map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
