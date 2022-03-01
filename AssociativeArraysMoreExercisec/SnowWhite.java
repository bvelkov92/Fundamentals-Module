package src.AssociativeArraysMoreExercisec;


import java.util.*;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Integer> dwarfs = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equals("Once upon a time")) {
            String[] tokens = input.split("<:>");
            String dwarfName = tokens[0].trim();
            String hatColor = tokens[1].trim();
            int physics = Integer.parseInt(tokens[2].trim());

            String key = dwarfName + ":" + hatColor;

            dwarfs.putIfAbsent(key, physics);
            if (!dwarfs.containsKey(key)) {
                dwarfs.put(key, physics);
            } else {
                if (dwarfs.get(key) < physics) {
                    dwarfs.put(key, physics);
                }
            }
        }

        dwarfs.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    if (res == 0) {
                        String x = e1.getKey().split(":")[1];
                        String y = e2.getKey().split(":")[1];
                        res = Long.compare(dwarfs.keySet().stream().filter(v -> v.split(":")[1].equals(y)).count(),
                                dwarfs.keySet().stream().filter(v -> v.split(":")[1].equals(x)).count());
                    }
                    return res;
                }).forEach(e -> {
                    System.out.printf("(%s) %s <-> %d%n",
                            e.getKey().split(":")[1],
                            e.getKey().split(":")[0],
                            e.getValue());
                });
    }
}
