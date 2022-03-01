package src.AssociativeArraysExercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();
        Map<String, List<String>> listOfStudents = new LinkedHashMap<>();

         while (!text.equals("end")){

             String [] code = text.split(" : ");

             String keyIsName = code[0];
             String nameIsValue = code[1];

             if (!listOfStudents.containsKey(keyIsName)){
                 listOfStudents.put(keyIsName, new ArrayList<>());
             }
             listOfStudents.get(keyIsName).add(nameIsValue);

             text= scanner.nextLine();
         }

                        listOfStudents.entrySet().stream()
                                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                                .forEach(entry -> {
                                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                                    entry.getValue().stream().sorted()
                                            .forEach(studentName -> System.out.println("-- " + studentName));});

    }

    }
