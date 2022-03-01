package src.SetsAndMapsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Map<String, StringBuilder> userLogs = new TreeMap<>();

         String inputInfo = scanner.nextLine();
         while (!inputInfo.equals("end")){
             StringBuilder ipInfo =new StringBuilder(inputInfo.split("\\s+")[0].split("=")[1]).append(" ");
             String user = inputInfo.split("\\s+")[2].split("=")[1];


             if (!userLogs.containsKey(user)){
                 userLogs.put(user,ipInfo);
             }else {
                 userLogs.get(user).append(ipInfo);
             }
             inputInfo= scanner.nextLine();
         }

         userLogs.entrySet().forEach(userName ->{

             System.out.println(userName.getKey()+": ");

             String [] ips = userName.getValue().toString().split(" ");
             Map<String,Integer> ipCounter = new LinkedHashMap<>();

             for (String ip:ips) {
                 if (!ipCounter.containsKey(ip)){
                     ipCounter.put(ip,1);
                 }else {
                     ipCounter.put(ip,ipCounter.get(ip)+1);
                 }
             }
                int counter = ipCounter.size();
             for (Map.Entry<String, Integer> stringIntegerEntry : ipCounter.entrySet()) {
                 System.out.printf("%s => %d", stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
                 counter--;
                 if (counter==0){
                     System.out.print("."+System.lineSeparator());
                 }else {
                     System.out.print(", ");
                 }
             }
         });
    }
}
