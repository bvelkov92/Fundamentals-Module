package src.AssociativeArraysMoreExercisec;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MobaChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<String, Map<String, Integer>> playerList = new LinkedHashMap<>();
        Map<String, Integer> namesAndSkills = new LinkedHashMap<>();

        while (!text.contains("Season end")) {

            String[] textArr = text.split(" ");

            String separator = textArr[1];

            if (separator.equals("->")) {
                String[] textArray = text.split(" -> ");
                String playerName = textArray[0];
                String position = textArray[1];
                int skills = Integer.parseInt(textArray[2]);


                if (!playerList.containsKey(playerName)) {
                    Map<String, Integer> currentSkills = new LinkedHashMap<>();
                    currentSkills.put(position, skills);
                    playerList.put(playerName, currentSkills);
                    namesAndSkills.put(playerName, skills);

                } else if (playerList.containsKey(playerName)) {
                    if (!playerList.get(playerName).containsKey(position)) {
                        playerList.get(playerName).put(position, skills);
                        namesAndSkills.put(playerName, playerList.get(playerName).get(position)+namesAndSkills.get(playerName));

                    } else if (playerList.get(playerName).containsKey(position)) {
                        boolean forUpdate = false;
                        int diff =0;
                        if (playerList.get(playerName).get(position) < skills) {
                            diff =skills- playerList.get(playerName).get(position);
                            playerList.get(playerName).put(position, skills);
                            forUpdate=true;
                        }
                        if (forUpdate){
                            namesAndSkills.put(playerName,namesAndSkills.get(playerName)+diff);
                        }
                    }
                }

            } else if (separator.equals("vs")) {

                String[] textArray = text.split(" vs ");
                String playerOne = textArray[0];
                String playerTwo = textArray[1];
                boolean stop = false;
                if (playerList.containsKey(playerOne) && playerList.containsKey(playerTwo)) {
                    for (Map.Entry<String, Integer> playersOne : playerList.get(playerOne).entrySet()) {
                        for (Map.Entry<String, Integer> playersTwo : playerList.get(playerTwo).entrySet()) {
                            if (playersOne.getKey().equals(playersTwo.getKey())) {
                                int skillPerFirst = namesAndSkills.get(playerOne);
                                int skillPerSecond = namesAndSkills.get(playerTwo);
                                if (skillPerFirst > skillPerSecond) {
                                    playerList.remove(playerTwo);
                                    namesAndSkills.remove(playerTwo);
                                } else if (skillPerFirst < skillPerSecond) {
                                    playerList.remove(playerOne);
                                    namesAndSkills.remove(playerOne);
                                }
                                stop = true;
                                break;
                            }
                        }
                        if (stop) {
                            break;
                        }
                    }
                }
            }
            text = scanner.nextLine();
        }

        namesAndSkills.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey())).forEach(name -> {

            System.out.printf("%s: %d skill%n",name.getKey(),name.getValue());
            String playerName = name.getKey();
            playerList.get(playerName).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                    .thenComparing(Map.Entry.comparingByKey())).forEach(result ->
                    System.out.printf("- %s <::> %d%n", result.getKey(), result.getValue()));
        });
    }
}
