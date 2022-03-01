package src.AssociativeArraysMoreExercisec;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        Map<String, String> data = new LinkedHashMap<>();

        while (!firstInput.equals("end of contests")) {

            String contest = firstInput.split(":")[0];
            String password = firstInput.split(":")[1];

            data.put(contest, password);
            firstInput = scanner.nextLine();
        }


        Map<String, Map<String, Integer>> userList = new LinkedHashMap<>();

        String secondInput = scanner.nextLine();
        while (!secondInput.equals("end of submissions")) {
            String contest = secondInput.split("=>")[0];
            String password = secondInput.split("=>")[1];
            String userName = secondInput.split("=>")[2];
            Integer points = Integer.parseInt(secondInput.split("=>")[3]);

            if (data.containsKey(contest) && data.get(contest).contains(password)) {

                if (!userList.containsKey(contest)) {
                    Map<String, Integer> currentMap = new HashMap<>();
                    currentMap.put(userName, points);
                    userList.put(contest, currentMap);
                } else if (userList.containsKey(contest)) {
                    if (userList.get(contest).containsKey(userName)) {
                        if (userList.get(contest).get(userName) < points) {
                            userList.get(contest).put(userName, points);
                        }
                    } else {
                        userList.get(contest).put(userName, points);
                    }
                }
            }
            secondInput = scanner.nextLine();
        }
        Map<String, Integer> teamLeader = new TreeMap<>();

        userList.forEach((key, nameMap) -> nameMap.forEach((key1, value) -> {
            if (!teamLeader.containsKey(key1)) {
                teamLeader.put(key1, value);

            } else {
                int currentPoints = teamLeader.get(key1);
                teamLeader.put(key1, currentPoints + value);
            }
        }));

        final String[] name = {""};
        final int[] valueForName = {0};

        teamLeader.entrySet().stream().forEach(e -> {
            if (e.getValue() > valueForName[0]) {
                valueForName[0] = e.getValue();
                name[0] = e.getKey();
            }
        });

        System.out.printf("Best candidate is %s with total %d points.%n", name[0], valueForName[0]);

        System.out.println("Ranking:");


        teamLeader.entrySet().stream().forEach((names -> { // лист с имената

            System.out.println(names.getKey());

            Map<String,Integer> currentMap = new LinkedHashMap<>();
            userList.entrySet().stream().forEach(contest -> { // лист със курсове, имена и точки;

                contest.getValue().entrySet().stream().forEach(points -> {
                    if (points.getKey().contains(names.getKey())) {
                        currentMap.put(contest.getKey(), points.getValue());
                    }
                });
            });
            currentMap.entrySet().stream().sorted((values, values1)-> values1.getValue().compareTo(values.getValue()))
                    .forEach(e-> System.out.printf("#  %s -> %d%n", e.getKey(),e.getValue()));
        }));
    }
}


