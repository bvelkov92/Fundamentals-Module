package src.ObjectAndClasses;

import java.util.*;


public class ExerciseOpinionPoll {

    static class ListOfPeoples {
        String name;
        int age;


        public int getAge() {
            return age;
        }

        ListOfPeoples(String name, int age) {
            this.name = name;
            this.age = age;
        }


        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.getName(), this.getAge());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<ListOfPeoples> peopleList = new ArrayList<>();

        int numberPeoples = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberPeoples; i++) {
            String[] currentRow = scanner.nextLine().split("\\s+");

            String currentName = currentRow[0];
            int currentAge = Integer.parseInt(currentRow[1]);

            ListOfPeoples currentHuman = new ListOfPeoples(currentName, currentAge);
            peopleList.add(currentHuman);
        }
        peopleList.sort(Comparator.comparing(ListOfPeoples::getName));

        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getAge() > 30) {
                System.out.println(peopleList.get(i));
            }
        }
    }
}
