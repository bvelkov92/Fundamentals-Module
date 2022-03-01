package src.DefiningExercise.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        List<Person> peoples = new ArrayList<>();
         int inputs = Integer.parseInt(scanner.nextLine());

         while (inputs-->0){
             String input = scanner.nextLine();
             String name = input.split("\\s+")[0];
             int age = Integer.parseInt(input.split("\\s+")[1]);

             if (age>30){
                 Person person = new Person(name,age);
                 peoples.add(person);
             }
         }
         peoples.sort(Comparator.comparing(Person::getName));

        for (Person person:peoples){
            System.out.println(person.toString());
        }
    }
}
