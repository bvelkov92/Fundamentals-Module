package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        int newInput;
        while (input != 0) {
            int newValue = input % 2;
            binary.push(newValue);
            newInput = input / 2;
            input = newInput;
        }
        if (binary.isEmpty()) {
            System.out.print(0);
        } else {
            binary.forEach(e1 -> System.out.print(e1.toString()));
        }
    }
}
