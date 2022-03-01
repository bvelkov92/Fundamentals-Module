package src.AssociativeArraysExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String endCommand = scanner.nextLine();

        Map<String, List<String>> codeList= new TreeMap<>();
         while (!endCommand.equals("End")){

             String companyName = endCommand.split(" -> ")[0];
             String code = endCommand.split(" -> ")[1];
             boolean isTrue = false;
             if (!codeList.containsKey(companyName)){
                 codeList.put(companyName, new ArrayList<>());
             }

                     if (codeList.get(companyName).contains(code)){
                         isTrue=true;
                 }
                     if (!isTrue) {
                         codeList.get(companyName).add(code);
                     }
             endCommand= scanner.nextLine();
         }

        for (Map.Entry<String, List<String>> item : codeList.entrySet()) {
            System.out.printf("%s%n", item.getKey());
            for (int i = 0; i < item.getValue().size(); i++) {
                System.out.printf("-- %s%n".trim(), item.getValue().get(i));
            }
        }

    }

    }
