package src.FunctionalProgramming;


import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static class Person {
        String name;
        int age;
        public Person(String name,int age){
            this.name=name;
            this.age=age;
        }
    }
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int numberPersons =Integer.parseInt(scanner.nextLine());
        List<Person> people = IntStream.range(0, numberPersons).mapToObj(ignored -> {
            String[] tokens = scanner.nextLine().split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        }).collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split(" ");


        people
                .stream()
                .filter(getFilter(condition,age))
                .forEach(printResult(format));

    }
public static Predicate<Person> getFilter (String condition, int age) {
    return condition.equals("older")
            ?  p -> p.age >= age
            :  p -> p.age <= age;

}
public static Consumer<Person> printResult (String[] format){
        if (format.length==2){
            return p-> System.out.println(p.name +" - "  +p.age);
        }else if(format[0].equals("name")){
        return p-> System.out.println(p.name);
    }else {
            return p-> System.out.println(p.age);
        }
}

}
