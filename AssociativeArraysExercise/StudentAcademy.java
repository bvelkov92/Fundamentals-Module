package src.AssociativeArraysExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int numberStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentList = new LinkedHashMap<>();

        for (int i = 0; i < numberStudents; i++) {


            String nameOfStudent = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());


            if(!studentList.containsKey(nameOfStudent)){
                studentList.put(nameOfStudent, new ArrayList<>());
            }
            studentList.get(nameOfStudent).add(grade);
        }
            Map<String, Double> result = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> item : studentList.entrySet()) {
            double sumGrade=0;
            for (int i = 0; i < item.getValue().size(); i++) {
                sumGrade+= item.getValue().get(i);
            }
            double AVG = sumGrade/item.getValue().size();
            if (AVG>=4.50) {
                result.put(item.getKey(), AVG);
            }
        }
        result.entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
                .forEach(item-> System.out.printf("%s -> %.2f%n", item.getKey(),item.getValue()));

    }

    }

