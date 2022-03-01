package src.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Map<String,Integer> minerList = new LinkedHashMap<>();
         String input = scanner.nextLine();
         while (!input.equals("stop")){
             String resource = input;
             int quantity = Integer.parseInt(scanner.nextLine());
             if (!minerList.containsKey(resource)){
                 minerList.put(resource,quantity);
             }else {
                 minerList.put(resource, minerList.get(resource)+quantity);
             }
             input= scanner.nextLine();
         }
        minerList.entrySet().forEach(e-> System.out.printf("%s -> %d%n",e.getKey(),e.getValue()));
    }
}
