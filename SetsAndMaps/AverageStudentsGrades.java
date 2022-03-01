package src.SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGradesList = new TreeMap<>();
        int studentsCounts = Integer.parseInt(scanner.nextLine());

        while (studentsCounts > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String key = input[0];
            double value = Double.parseDouble(input[1]);
            if (!studentGradesList.containsKey(key)) {
                List<Double> currentList = new ArrayList<>();
                currentList.add(value);
                studentGradesList.put(key, currentList);
            } else {
                studentGradesList.get(key).add(value);
            }
            studentsCounts--;
        }

        studentGradesList.entrySet().stream().forEach(key ->{
            double avg = 0;
            System.out.printf("%s -> ",key.getKey());
            for (int index = 0; index < key.getValue().size(); index++) {
                avg+= key.getValue().get(index);
                System.out.printf("%.2f ",key.getValue().get(index));
            }
            System.out.printf("(avg: %.2f)%n", avg/key.getValue().size());
        });

    }
}
