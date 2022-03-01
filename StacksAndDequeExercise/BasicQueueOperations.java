package src.StacksAndDequeExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int stackSize = scanner.nextInt();
        int elementToPop = scanner.nextInt();
        int numberForSearch = scanner.nextInt();

        for (int numElements = 0; numElements < stackSize; numElements++) {
            int currentElement = scanner.nextInt();
            stack.offer(currentElement);
        }

        boolean isTrue = false;

        while (elementToPop>0){
            if (!stack.isEmpty()) {
                stack.poll();
            }
            elementToPop--;
        }
        for (Integer element: stack) {
            if (element==numberForSearch){
                isTrue=true;
                break;
            }
        }
        if (isTrue){
            System.out.println("true");
        }else if (!stack.isEmpty()){
            System.out.println(Collections.min(stack));
        }else {
            System.out.println(0);
        }
    }
}
