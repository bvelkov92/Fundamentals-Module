package src.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numberList = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (String s : input) {
            double currentNumber = Double.parseDouble(s);
            if (!numberList.containsKey(currentNumber)) {
                numberList.put(currentNumber, 1);
            } else {
                numberList.put(currentNumber, numberList.get(currentNumber) + 1);
            }
        }
        numberList.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
