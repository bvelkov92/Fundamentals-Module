package src.StacksAndDequeExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         StringBuilder stringBuilder = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
         int numOperations = Integer.parseInt(scanner.nextLine());
         while (numOperations>0){
             String [] commandArr = scanner.nextLine().split("\\s+");
             int command =Integer.parseInt(commandArr[0]);
             if (command==1){
                 stack.push(stringBuilder.toString());
                 String text = commandArr[1];
                 stringBuilder.append(text);
             }else if (command==2){
                 int count = Integer.parseInt(commandArr[1]);
                 stringBuilder.delete(stringBuilder.length()-count,stringBuilder.length());
             stack.push(stringBuilder.toString());
             }else if (command==3){
                 int index = Integer.parseInt(commandArr[1]);
                 if (!stack.isEmpty()) {
                     System.out.println(stringBuilder.charAt(index-1));
                 }
             }else if (command==4){
                 if (!stack.isEmpty()) {
                   stringBuilder= new StringBuilder(stack.pop());
                 }
             }

             numOperations--;
         }
    }
}
       // •	"1 {string}" - appends [string] to the end of the text.
       // •	"2 {count}" - erases the last [count] elements from the text.
       // •	"3 {index}" - returns the element at position [index] from the text.
       // •	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation
