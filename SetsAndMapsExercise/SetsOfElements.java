package src.SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> finallySet = new LinkedHashSet<>();

        String [] input =scanner.nextLine().split("\\s+");
        int sizeOfFirstSet = Integer.parseInt(input[0]);
        int sizeOfSecondSet = Integer.parseInt(input[1]);


            for (int index = 0; index < sizeOfFirstSet; index++) {
                int inputed = Integer.parseInt(scanner.nextLine());
                firstSet.add(inputed);

            }

            for (int index = 0; index < sizeOfSecondSet; index++) {
                int inputed=Integer.parseInt(scanner.nextLine());
                secondSet.add(inputed);
            }

        System.out.print("");
        while (!firstSet.isEmpty()) {
            int firstCard =firstSet.iterator().next();
            if (secondSet.contains(firstCard)) {
                finallySet.add(firstCard);
            }
            firstSet.remove(firstCard);
        }
        for (Integer number: finallySet) {
            System.out.print(number +" ");
        }
    }
}
