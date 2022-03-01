package src.AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");

        Map<String, Integer> charMap = new LinkedHashMap<>();
        for (String s : text) {
            String[] currentText = s.split("");
            for (int i = 0; i < currentText.length; i++) {
                String currentSymbol = currentText[i];

                if (charMap.containsKey(currentSymbol)) {
                    charMap.put(currentSymbol, charMap.get(currentSymbol) + 1);
                } else {
                    charMap.put(currentSymbol, 1);
                }
            }
        }
            for (Map.Entry<String, Integer> item : charMap.entrySet()) {
                System.out.printf("%s -> %d%n", item.getKey(), item.getValue());
            }

        }
    }

