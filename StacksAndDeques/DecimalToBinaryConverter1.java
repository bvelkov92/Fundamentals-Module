package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryCode = new ArrayDeque<>();
        int currentNumber = decimalNumber;

        while (currentNumber != 0) {
            binaryCode.push(currentNumber % 2);
            currentNumber /= 2;

        }

        if (binaryCode.isEmpty()) {
            System.out.print(0);
        } else {
            for (Integer e : binaryCode) {
                System.out.print(e);
            }
        }
    }
}
