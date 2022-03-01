package src.ObjectAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

   private static class Student{
        String firstName;
        String lastName;
        int age;
        String town;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getTown() {
            return town;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();
        List<Student> studentInformation = new ArrayList<>();

         while (!text.equals("end")){

             String [] informationForStudent = text.split(" ");

             String firstName = informationForStudent[0];
             String lastName = informationForStudent[1];
             int age = Integer.parseInt(informationForStudent[2]);
             String town = informationForStudent[3];

             Student currentStudent = new Student();

             currentStudent.setFirstName(firstName);
             currentStudent.setLastName(lastName);
             currentStudent.setAge(age);
             currentStudent.setTown(town);

             studentInformation.add(currentStudent);

             text = scanner.nextLine();
         }

         String command = scanner.nextLine();

        for (Student student: studentInformation) {
            if (student.getTown().equals(command)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(),student.getLastName(), student.getAge());
            }
        }
    }
}
