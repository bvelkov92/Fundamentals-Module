package src.SetsAndMapsExercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HandsOfCards {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> playerCards = new LinkedHashMap<>();
         String input = scanner.nextLine();
         while (!input.equals("JOKER")){

             String name  = input.split(":\\s+")[0];
             String[] cards = input.split(":\\s+")[1].split(", ");
             Set<String> setOfPlayer = new LinkedHashSet<>(Arrays.asList(cards));
             List<String> currentList = new ArrayList<>(setOfPlayer);
             if (!playerCards.containsKey(name)){
                 playerCards.put(name,currentList);
             }else {
                 currentList.forEach(card -> {
                     if (!playerCards.get(name).contains(card)){
                         playerCards.get(name).add(card);
                     }
                 });
             }
             input = scanner.nextLine();
         }

        playerCards.forEach((key, value) -> {
            System.out.printf("%s: ", key);
            AtomicInteger totalPower = new AtomicInteger();
            value.forEach(card -> {
                StringBuilder powerBuilder = new StringBuilder();
                StringBuilder typeBuilder = new StringBuilder();

                char[] charArr = card.toCharArray();
                for (char c : charArr) {
                    if (c == 'S' || c == 'H' || c == 'D' || c == 'C') {
                        typeBuilder.append(c);
                    } else {
                        powerBuilder.append(c);
                    }
                }
                int power =1;
                switch (powerBuilder.toString()){
                    case "J":
                        power=11;
                        break;
                    case "Q":
                        power=12;
                        break;
                    case "K":
                        power=13;
                        break;
                    case "A":
                        power=14;
                        break;
                    default:power=Integer.parseInt(powerBuilder.toString());
                }

                String typeString = typeBuilder.toString();
                int type = 1;
                switch (typeString) {
                    case "S":
                        type = 4;
                        break;
                    case "H":
                        type = 3;
                        break;
                    case "D":
                        type = 2;
                        break;
                    case "C":
                        break;
                }
                int currentPower = power * type;
                totalPower.addAndGet(currentPower);
            });
            System.out.print(totalPower + System.lineSeparator());
        });
    }
}
