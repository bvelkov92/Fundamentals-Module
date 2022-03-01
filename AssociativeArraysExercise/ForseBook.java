package src.AssociativeArraysExercise;

import java.util.*;

public class ForseBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, List<String>> forceBook = new LinkedHashMap<>();
        while (!text.equals("Lumpawaroo")) {

            if (text.contains("|")) {

               String forceSide = text.split("\\s+\\|\\s+")[0];
               String forceUser = text.split("\\s+\\|\\s+")[1];

                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                boolean isExist = false;
                for (List<String> currentSide : forceBook.values()) {
                    if (currentSide.contains(forceUser)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    forceBook.get(forceSide).add(forceUser);
                }
            }
            else if (text.contains("->")){
                String forceUser = text.split("\\s+->\\s+")[0];
                String forseSide = text.split("\\s+->\\s+")[1];

                    forceBook.forEach((key, value) -> value.remove(forceUser));

                   forceBook.putIfAbsent(forseSide,new ArrayList<>());
                    forceBook.get(forseSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forseSide);
                }
            text= scanner.nextLine();
        }


        forceBook.entrySet().stream().filter(e1-> e1.getValue().size()>0)
                .sorted((e1,e2)->{
                int sortedResult = Integer.compare(e2.getValue().size(),e1.getValue().size());

                if (sortedResult==0) {
                    sortedResult = e1.getKey().compareTo(e2.getKey());
                }
                return  sortedResult;
                }).forEach(entry -> {
                            System.out.printf("Side: %s, Members: %s%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().stream().sorted().forEach(user -> System.out.println("! " +user));
                        });
        }

    }