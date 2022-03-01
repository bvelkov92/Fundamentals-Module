package src.AssociativeArrayLection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> fruitList = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> e.length() % 2 == 0)
                .collect(Collectors.toList());


        for (String fruit : fruitList) {
            System.out.print(fruit +System.lineSeparator());
        }
    }
}
