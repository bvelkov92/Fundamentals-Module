package src.AssociativeArraysExercise;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();

        Map<String, Integer> studentTestInformation = new HashMap<>();
        Map<String, Integer> numSubmits = new HashMap<>();


         while (!text.equals("exam finished")){

             String userName = text.split("-")[0];
             String language = text.split("-")[1];

             if (text.split("-").length==2) {
                 studentTestInformation.remove(userName);
             }else {
                 Integer points = Integer.parseInt(text.split("-")[2]);
                 if (!studentTestInformation.containsKey(userName)){
                     studentTestInformation.putIfAbsent(userName, points);
                 numSubmits.putIfAbsent(language, 0);
             }else{
                     if (points> studentTestInformation.get(userName)) {
                         studentTestInformation.put(userName, points);
                     }
             }
                 numSubmits.put(language, numSubmits.get(language) + 1);
             }

             text= scanner.nextLine();
             }
        System.out.println("Results:");
            studentTestInformation.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
                    .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(e-> System.out.println(e.getKey() + " | " +e.getValue()));

        System.out.println("Submissions:");
            numSubmits.entrySet().stream()
                    .sorted(Map.Entry.<String,Integer> comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(e-> System.out.println(e.getKey() +" - " + e.getValue()));
         }

    }
