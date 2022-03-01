package src.StacksAndDequeExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCycles = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int numCycle = 0; numCycle < numberCycles; numCycle++) {
            String[] commandArr = scanner.nextLine().split("\\s+");

            int mainCommand = Integer.parseInt(commandArr[0]);
            if (mainCommand == 1) {
                int element = Integer.parseInt(commandArr[1]);
                stack.push(element);
            } else if (mainCommand == 2) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
