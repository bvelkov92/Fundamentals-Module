package src.AssociativeArrayLection;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumber {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        List<Double> stringList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> numberList = new TreeMap<>();
        for (int i = 0; i < stringList.size(); i++) {
            Double key = stringList.get(i);
            if (numberList.containsKey(key)) {
                numberList.put(key, numberList.get(key)+1);
            } else {
                numberList.put(key, 1);
            }
        }
        for (Map.Entry<Double, Integer> item : numberList.entrySet()) {
            System.out.printf("%.0f -> %d%n", item.getKey(), item.getValue());
        }
    }
}
