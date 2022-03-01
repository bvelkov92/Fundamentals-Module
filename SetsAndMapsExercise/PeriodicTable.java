package src.SetsAndMapsExercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int number = Integer.parseInt(scanner.nextLine());
        Set<String> mySet = new TreeSet<>();

         while (number>0){
             String [] input = scanner.nextLine().split("\\s");
             Collections.addAll(mySet, input);

             number--;
         }

        for (String element:mySet) {
            System.out.print(element +" ");
        }
    }
}
