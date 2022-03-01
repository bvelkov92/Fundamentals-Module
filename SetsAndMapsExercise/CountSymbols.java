package src.SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String input = scanner.nextLine();
        Map<Character, Integer> symbolsRepeatCounter = new TreeMap<>();

        char [] array = input.toCharArray();
        for (char symbol : array) {
            if (!symbolsRepeatCounter.containsKey(symbol)) {
                symbolsRepeatCounter.put(symbol, 1);
            } else {
                symbolsRepeatCounter.put(symbol, symbolsRepeatCounter.get(symbol) + 1);
            }
        }
        symbolsRepeatCounter.entrySet().forEach(e-> System.out.printf("%c: %d time/s%n",e.getKey(),e.getValue()));
    }
}
