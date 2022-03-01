package src.AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        Map<String, Integer> materialMap = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        boolean target = false;
        materialMap.put("shards", 0);
        materialMap.put("fragments", 0);
        materialMap.put("motes", 0);
        while (!target) {
            List<String> startInformation = Arrays.stream(text.toLowerCase().split(" ")).collect(Collectors.toList());

            for (int i = 0; i < startInformation.size(); i += 2) {
                Integer currentQuantity = Integer.parseInt(startInformation.get(i));
                String currentItem = startInformation.get(i + 1);
                if (currentItem.equals("shards") || currentItem.equals("fragments") || currentItem.equals("motes")) {
                    mapPut(materialMap, currentItem, currentQuantity);
                } else {
                    mapPut(junkMaterials, currentItem, currentQuantity);
                }
                String winner = "";
                String endName = endProgram(materialMap);
                if (!endName.equals("notEnd")) {
                    if (endName.equals("shards")) {
                        winner = "Shadowmourne";
                    } else if (endName.equals("fragments")) {
                        winner = "Valanyr";
                    } else if (endName.equals("motes")) {
                        winner = "Dragonwrath";

                    }
                    System.out.printf("%s obtained!%n", winner);
                    materialMap.put(endName, materialMap.get(endName) - 250);
                    target = true;
                    break;
                }
            }
            if (!target) {
                text = scanner.nextLine();
            }
        }


//        materialMap.entrySet()
//                .stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .forEach(e->System.out.printf("%s: %d%n", e.getKey(),e.getValue()));

        materialMap.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));


        junkMaterials.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e->System.out.printf("%s: %d%n", e.getKey(),e.getValue()));
    }

    private static void mapPut(Map<String, Integer> currentMap, String key, Integer quantity) {
        if (currentMap.containsKey(key)) {
            currentMap.put(key, currentMap.get(key) + quantity);
        } else {
            currentMap.put(key, quantity);
        }
    }

    private static String endProgram(Map<String, Integer> currentMap) {
        String notEnd = "notEnd";
        for (Map.Entry<String, Integer> item : currentMap.entrySet()) {
            if (item.getValue() >= 250
                    && (item.getKey().equals("shards")
                    || item.getKey().equals("fragments")
                    || item.getKey().equals("motes"))) {
                return item.getKey();
            }
        }
        return notEnd;
    }
}
