package src.SetsAndMaps;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> studentList = new TreeMap<>();

        int numStudents = Integer.parseInt(scanner.nextLine());
        while (numStudents > 0) {
            String studentName = scanner.nextLine();
            double[] grades =
                    Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double avgSum = 0;
            for (Double grade : grades) {
                avgSum += grade;
            }
            avgSum /= grades.length;

            studentList.put(studentName, avgSum);

            numStudents--;
        }

        studentList.entrySet().forEach(student -> {
            DecimalFormat currentValue = new DecimalFormat("0.##########################################");
            System.out.printf("%s is graduated with " + currentValue.format(student.getValue()) +"%n",
                    student.getKey());
        });
    }
}