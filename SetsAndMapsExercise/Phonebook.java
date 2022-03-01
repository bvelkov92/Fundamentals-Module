package src.SetsAndMapsExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();

        Map<String, String> phoneBook = new HashMap<>();
         while (!input.equals("search")){
                String name = input.split("-")[0];
                String phoneNumber = input.split("-")[1];
                phoneBook.put(name,phoneNumber);
             input= scanner.nextLine();
         }
         String searchName = scanner.nextLine();
         while (!searchName.equals("stop")){
             if (phoneBook.containsKey(searchName)){
                 System.out.printf("%s -> %s%n", searchName,phoneBook.get(searchName));
             }else {
                 System.out.printf("Contact %s does not exist.%n",searchName);
             }
             searchName= scanner.nextLine();
         }
    }
}
