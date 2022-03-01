package src.TextProcessingExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        BigInteger numberOne = new BigInteger(scanner.nextLine());
        BigInteger numberTwo = new BigInteger(scanner.nextLine());
        System.out.println(numberOne.multiply(numberTwo));
    }
}
