package src.RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();
         String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>\\d+.?\\d+)!(?<quantity>\\d+)";
        List<String>furnitureList = new ArrayList<>();
       double totalSum = 0;
         while (!text.equals("Purchase")) {
             Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(text);

             if (matcher.find()) {
                 String furniture = matcher.group("furnitureName");
                 double price = Double.parseDouble(matcher.group("price"));
                 int quantity = Integer.parseInt(matcher.group("quantity"));
                 totalSum += price * quantity;
                 furnitureList.add(furniture);
             }
             text= scanner.nextLine();
         }
        System.out.println("Bought furniture:");
         furnitureList.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f%n",totalSum);
    }
}
