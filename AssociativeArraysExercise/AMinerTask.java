package src.AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();

        Map<String, Integer> minerMap = new LinkedHashMap<>();
         while (!text.equals("stop")){
             Integer number = Integer.parseInt(scanner.nextLine());

             if (minerMap.containsKey(text)){
                 minerMap.put(text,minerMap.get(text)+number);
             }else{
                 minerMap.put(text,number);
             }
             text= scanner.nextLine();
         }

        for (Map.Entry<String, Integer> item : minerMap.entrySet()) {
            System.out.printf("%s -> %d%n",item.getKey(),item.getValue());
        }

    }
}
