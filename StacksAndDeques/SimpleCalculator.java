package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> result = new ArrayDeque<>();

        String [] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
           char currentSymbol = input[i].charAt(0);
           if (Character.isDigit(currentSymbol) && result.isEmpty()){
               int currentDig = Integer.parseInt(input[i]);
               result.push(currentDig);
           }else if (Character.isDigit(currentSymbol) && !result.isEmpty()){
               int currRes = result.pop();
               String currentSymbols = input[i-1];
               if (currentSymbols.equals("-")){
                   currRes-=Integer.parseInt(input[i]);
               }else if (currentSymbols.equals("+")){
                   currRes+=Integer.parseInt(input[i]);
               }else if (currentSymbols.equals("*")){
                   currRes*=Integer.parseInt(input[i]);
               }else {
                   currRes/=Integer.parseInt(input[i]);
               }

               result.push(currRes);
           }
        }
        System.out.println(result.peek());
    }
}
