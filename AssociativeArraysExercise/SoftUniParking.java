package src.AssociativeArraysExercise;

import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int numberCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> mapList = new LinkedHashMap<>();

        for (int i = 0; i < numberCommands; i++) {

            String [] currentCommand = scanner.nextLine().split(" ");
            String command = currentCommand[0];
            String nameForKey = currentCommand[1];
            switch (command){

                case "register":

                    String licensePlate = currentCommand[2];
                    if (mapList.containsKey(nameForKey)){
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);
                    }else{
                        mapList.put(nameForKey,licensePlate);
                        System.out.printf("%s registered %s successfully%n", nameForKey, licensePlate);
                    }
                    break;

                case "unregister": {

                    if (!mapList.containsKey(nameForKey)) {
                        System.out.printf("ERROR: user %s not found%n", nameForKey);
                    } else {
                        System.out.printf("%s unregistered successfully%n",nameForKey);
                        mapList.remove(nameForKey);

                    }
                }
                    break;
            }

        }
        for (Map.Entry<String, String> item : mapList.entrySet()) {
            System.out.printf("%s => %s%n",item.getKey(), item.getValue() );
        }

    }
}
