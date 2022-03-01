package src.SetsAndMapsExercise;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();
        Set<String> rejectedEnd = Set.of("us", "uk", "com");
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            emails.put(name, email);
            input = scanner.nextLine();
        }
        if (!emails.isEmpty()) {
            emails.entrySet().forEach((name -> {
                String emailEnd = name.getValue().split("\\.")[name.getValue().split("\\.").length - 1].toLowerCase();
                if (rejectedEnd.contains(emailEnd)) {
                    emails.remove(name);
                } else {
                    System.out.printf("%s -> %s%n", name.getKey(), name.getValue());
                }
            }));
        }
    }
}
