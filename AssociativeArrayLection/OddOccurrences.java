package src.AssociativeArrayLection;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> startList = Arrays.stream(scanner.nextLine().toLowerCase().split(" ")).collect(Collectors.toList());

        Map<String, Integer> languageList = new LinkedHashMap<>();

        for (int i = 0; i < startList.size(); i++) {
            String key = startList.get(i);

            if (languageList.containsKey(key)) {
                languageList.put(key, languageList.get(key) + 1);
            } else {
                languageList.put(key, 1);
            }
        }
        List<String> finalList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : languageList.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                finalList.add(entry.getKey());
            }
        }
        for (int i = 0; i < finalList.size(); i++) {
            if (i == finalList.size() - 1) {
                System.out.print(finalList.get(i));
            } else {
                System.out.print(finalList.get(i) + ", ");
            }
        }
    }
}


