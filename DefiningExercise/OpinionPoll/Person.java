package src.DefiningExercise.OpinionPoll;

public class Person {
    String name;

    public int getAge() {
        return age;
    }

    int age;

    public String getName() {
        return name;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return name +" - " +age;
    }
}
