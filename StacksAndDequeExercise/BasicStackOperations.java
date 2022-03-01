package src.StacksAndDequeExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
         int stackSize = scanner.nextInt();
         int elementToPop = scanner.nextInt();
         int numberForSearch = scanner.nextInt();

         boolean elementIsFound = false;
        for (int numElements = 0; numElements < stackSize-elementToPop; numElements++) {
            int currentElement = scanner.nextInt();
            if (currentElement==numberForSearch){
                elementIsFound=true;
            }
            stack.push(currentElement);
        }

        if (elementIsFound){
            System.out.println("true");
        }else if (!stack.isEmpty()){
            System.out.println(Collections.min(stack));
        }else {
            System.out.println(0);
        }
    }
}
