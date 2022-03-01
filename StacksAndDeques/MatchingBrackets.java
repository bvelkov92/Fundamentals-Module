package src.StacksAndDeques;


import java.util.ArrayDeque;

import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> names = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            names.offer(input[i]);
        }
        int num = Integer.parseInt(scanner.nextLine());

        while (names.size()!=1){
            for (int i = 0; i < num; i++) {
                if (i==num-1){
                    String cureentRemove =names.poll();
                    System.out.println("Removed "+cureentRemove);
                }else {
                    String currentName= names.poll();
                    names.offer(currentName);
                }
            }
        }
        System.out.println("Last is "+names.peek());
    }
}
