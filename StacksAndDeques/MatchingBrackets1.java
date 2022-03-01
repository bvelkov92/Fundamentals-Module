package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MatchingBrackets1 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String input = scanner.nextLine();

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < input.toCharArray().length; i++) {
            char symbol = input.charAt(i);
            if (symbol =='(') {
                arrayDeque.push(i);
            }else if (symbol==')') {
                int startIndex = arrayDeque.pop();
                String contest = input.substring(startIndex,i+1);
                System.out.println(contest);
            }
        }

    }
}
