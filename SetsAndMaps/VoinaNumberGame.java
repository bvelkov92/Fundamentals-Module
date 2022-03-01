package src.SetsAndMaps;

import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> playerOneCards = new LinkedHashSet<>();
        Set<Integer> playerTwoCards = new LinkedHashSet<>();



        //26 58 16 92 44 65 65 77 57 23 71 57 7 52 85 44 32 70 38 23
        //43 95 33 51 62 93 57 55 0 31 32 95 68 34 30 51 37 32 11 97
        String [] inputCardOne = scanner.nextLine().split("\\s+");
        addCards(inputCardOne,playerOneCards);

        String [] inputCardTwo = scanner.nextLine().split("\\s+");
        addCards(inputCardTwo,playerTwoCards);

        int counter = 50;
        while (counter>=0 && !playerOneCards.isEmpty() && !playerTwoCards.isEmpty()){

            int firstCard = playerOneCards.iterator().next();
            int secondCard = playerTwoCards.iterator().next();
            playerOneCards.remove(firstCard);
            playerTwoCards.remove(secondCard);

            if (firstCard > secondCard){
                playerOneCards.add(firstCard);
                playerOneCards.add(secondCard);
            }else if(firstCard < secondCard) {
                playerTwoCards.add(secondCard);
                playerTwoCards.add(firstCard);
            }
            counter--;
        }
        if (playerOneCards.size()> playerTwoCards.size()){
            System.out.println("First player win!");
        }else if (playerOneCards.size()<playerTwoCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }

    public static void addCards (String [] inputArr, Set<Integer> playerSet){
        for (String element: inputArr) {
            int currentSymbol = Integer.parseInt(element);
            playerSet.add(currentSymbol);
        }
    }
}
