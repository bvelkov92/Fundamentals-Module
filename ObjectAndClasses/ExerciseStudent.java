package src.ObjectAndClasses;

import java.util.*;

public class ExerciseStudent {
     private static class Students{
        String firstName;
        String lastName;
        Double grade;

         public String getFirstName() {
             return firstName;
         }

         public String getLastName() {
             return lastName;
         }

         public Double getGrade() {
             return grade;
         }

         Students(String firstname, String lastName, Double grade){
            this.firstName=firstname;
            this.lastName=lastName;
            this.grade=grade;
        }



         @Override
         public String toString() {
             return String.format("%s %s: %.2f", this.getFirstName(),this.getLastName(),this.getGrade());
         }
     }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int numStudents = Integer.parseInt(scanner.nextLine());

        List<Students> studentsList = new ArrayList<>();
        for (int i = 1; i <= numStudents; i++) {
            String [] informationForCurrentStudent = scanner.nextLine().split(" ");

            String currentFirstName = informationForCurrentStudent[0];
            String currentLastName = informationForCurrentStudent[1];
            Double currentGrade =Double.parseDouble(informationForCurrentStudent[2]);

            Students currentStudent = new Students(currentFirstName,currentLastName,currentGrade);
            studentsList.add(currentStudent);
        }

        studentsList.sort(Comparator.comparing(Students::getGrade).reversed());
        for (Students student:studentsList) {
            System.out.println(student);
        }
    }
}
