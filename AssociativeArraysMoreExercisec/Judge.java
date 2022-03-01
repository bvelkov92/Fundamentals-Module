package src.AssociativeArraysMoreExercisec;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<String, Map<String, Integer>> contestList = new LinkedHashMap<>();
        Map<String, Integer> individualPoints = new LinkedHashMap<>();

        while (!text.equals("no more time")) {

            String[] startCommand = text.split(" -> ");
            String studentName = startCommand[0];
            String contestName = startCommand[1];
            Integer points = Integer.parseInt(startCommand[2]);

            Map<String, Integer> currentInformation = new LinkedHashMap<>();
            currentInformation.put(studentName, points);
            boolean replace = false;
            boolean isNew = true;
            int diff=0;
            if (!contestList.containsKey(contestName)) {
                contestList.put(contestName, currentInformation); //Общ списък
            } else if (contestList.containsKey(contestName) && !contestList.get(contestName).containsKey(studentName)) {
                contestList.get(contestName).put(studentName, points);
            } else if(contestList.containsKey(contestName) && contestList.get(contestName).containsKey(studentName)){
                isNew=false;
                int currentPoints = contestList.get(contestName).get(studentName);
                if (currentPoints <= points) {
                    diff =points - contestList.get(contestName).get(studentName);
                    contestList.get(contestName).put(studentName, points);
                    isNew =false;
                    replace=true;
                }
            }
                if (!individualPoints.containsKey(studentName)) {
                    individualPoints.put(studentName, points);
                } else if (isNew) {
                    individualPoints.put(studentName, individualPoints.get(studentName) + points);
                }else if (replace) {
                    individualPoints.put(studentName, individualPoints.get(studentName)+diff);
                }
            text = scanner.nextLine();
        }

        contestList.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            Map<String, Integer> currentContestList = new LinkedHashMap<>();
            int counter = 1;
            value.entrySet().stream().sorted((Map.Entry.<String,Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey())))
                    .forEach(item -> currentContestList.put(item.getKey(), item.getValue()));

            Map<String, Integer> sortedCurrentMap = new LinkedHashMap<>();
            currentContestList.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(item ->
                            sortedCurrentMap.put(item.getKey(), item.getValue()));


            for (Map.Entry<String, Integer> entry1 : sortedCurrentMap.entrySet()) {
                System.out.printf("%d. %s <::> %d%n", counter, entry1.getKey(), entry1.getValue());
                counter++;
            }
        });

                     System.out.println("Individual standings:");
                    Map<String,Integer> finalIndividualPoints = new LinkedHashMap<>();
                   individualPoints.entrySet().stream().sorted((Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey())))
                           .forEach(newValue -> finalIndividualPoints.put(newValue.getKey(),newValue.getValue()));
                   int counter = 1;

        for (Map.Entry<String,Integer> item:finalIndividualPoints.entrySet()){
            System.out.printf("%d. %s -> %d%n", counter,item.getKey(),item.getValue());
            counter++;
        }
                 }

    }
//Rolland -> Web -> 500
//Rolland -> Web -> 100
//Alene -> Web -> 460
//Alene -> Web -> 100
//Genevieve -> DB -> 345
//Linette -> Tech -> 214
//Davie -> DS -> 180
//Davie -> DS -> 100
//no more time