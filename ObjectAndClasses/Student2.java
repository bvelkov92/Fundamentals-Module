package src.ObjectAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student2 {

   private static class Student{
        String firstName;
        String lastName;
        int age;
        String town;

        Student (String firstName, String lastName,int age,String town){
            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.town=town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old%n", this.getFirstName(),this.getLastName(), this.getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!text.equals("end")){

            String [] informationForStudent = text.split("\\s+");

            String firstName = informationForStudent[0];
            String lastName = informationForStudent[1];
            int age = Integer.parseInt(informationForStudent[2]);
            String town = informationForStudent[3];

            Student currentStudent = new Student(firstName,lastName,age,town);

            int searchingIndex = existingIndex(studentList,firstName,lastName);

            if (searchingIndex!=-1){
                studentList.get(searchingIndex).setAge(age);
                studentList.get(searchingIndex).setTown(town);
            }else {
                studentList.add(currentStudent);
            }

            text = scanner.nextLine();
        }

        String command = scanner.nextLine();

        for (Student student: studentList) {
            if (student.getTown().equals(command)){
                System.out.print(student);
            }
        }
    }

    public static  int existingIndex(List<Student> studentList, String firstName, String lastName){
        for (int i = 0; i < studentList.size(); i++) {
            String currentFirstName = studentList.get(i).getFirstName();
            String currentlastName = studentList.get(i).getLastName();

            if (currentFirstName.equals(firstName) && currentlastName.equals(lastName)){
                return i;
            }
        }
        return -1;
    }
}
