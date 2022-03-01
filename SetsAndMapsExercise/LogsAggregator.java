package src.SetsAndMapsExercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int inputLines = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeSet<String>> userAndIp = new TreeMap<>();
        TreeMap<String,Integer> userAndDuration = new TreeMap<>();

        for (int inputTime = 0; inputTime < inputLines; inputTime++) {
            String []  input = scanner.nextLine().split("\\s+");
            String ip =  input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!userAndIp.containsKey(user)){
                userAndIp.put(user,new TreeSet<>(){{add(ip);}});
                userAndDuration.put(user,duration);
            }else{
                    userAndIp.get(user).add(ip);
                userAndDuration.put(user,userAndDuration.get(user)+duration);
            }
        }
        userAndDuration.forEach((key, value) ->{

            System.out.println(String.format("%s: %d %s", key, value, userAndIp.get(key).toString()));

        });
        }

    }