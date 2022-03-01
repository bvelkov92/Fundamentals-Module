package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator1 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] input =scanner.nextLine().split("\\s+");

        ArrayDeque<String> calculator = new ArrayDeque<>();
        Collections.addAll(calculator,input);

        while (calculator.size()>1){
            int firstNumber = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int secondNumber = Integer.parseInt(calculator.pop());
            int result=0;
            if (operator.equals("+")){
                result=firstNumber+secondNumber;
            }else{
                result=firstNumber-secondNumber;
            }
            calculator.push(String.valueOf(result));
        }
        System.out.println(calculator.peek());
    }
}
