package src.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        UnaryOperator<Integer> add = n ->n+=1;
        UnaryOperator<Integer> multiply = n ->n*=2;
        UnaryOperator<Integer> subtract = n ->n-=1;
        Consumer<Integer> printResult = n -> System.out.print(n +" ");

        String command = scanner.nextLine();
        while (!command.equals("end")){

            if (command.equals("add")){
           numList= numList.stream().map(add).collect(Collectors.toList());
            }else if (command.equals("multiply")){
               numList= numList.stream().map(multiply).collect(Collectors.toList());
            }else if (command.equals("subtract")){
                numList=numList.stream().map(subtract).collect(Collectors.toList());
            }else if(command.equals("print")){
                numList.forEach(printResult);
                System.out.println();
            }
            command= scanner.nextLine();
        }
    }
}
