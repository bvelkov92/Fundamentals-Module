package src.StacksAndDequeExercise;


import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean notBalanced = false;
        for (int index = 0; index < input.length(); index++) {

            if (input.charAt(index)=='{' || input.charAt(index)=='(' || input.charAt(index)=='['){
                stack.push(input.charAt(index));
            }else if (input.charAt(index)=='}' || input.charAt(index)==')' || input.charAt(index)==']'){
                if (stack.isEmpty()){
                    notBalanced=true;
                    break;
                }
                char lastSymbol = stack.pop();
                char currentSymbol = input.charAt(index);
                if( (lastSymbol=='{' && currentSymbol !='}') || (lastSymbol=='(' && currentSymbol !=')')
                        || (lastSymbol=='[' && currentSymbol !=']')){
                    notBalanced = true;
                    break;
                }
            }
        }

        if (notBalanced || input.length()<=1 || input.length()%2!=0){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }
}
