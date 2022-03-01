package src.DefiningExercise.CompanyRoster;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> peoples = new ArrayList<>();
        Map<String, Map<String, Double>> departmentList = new HashMap<>();

        int numberInputs = Integer.parseInt(scanner.nextLine());
        while (numberInputs-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee;

            if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 5 && input[4].contains("@")) {
                String email = input[4];
                employee = new Employee(name, salary, position, department, email);
            } else {
                int age = Integer.parseInt(input[4]);
                employee = new Employee(name, salary, position, department, age);
            }

            peoples.add(employee);
            if (!departmentList.containsKey(department)) {
                Map<String, Double> currentMap = new LinkedHashMap<>();
                currentMap.put(name, salary);
                departmentList.put(department, currentMap);
            } else if (departmentList.containsKey(department) && !departmentList.get(department).containsKey(name)) {
                departmentList.get(department).putIfAbsent(name, salary);
            }
        }
        String departmentHighAVGSalary = "";
        AtomicReference<Double> currentavg = new AtomicReference<>((double) 0);
        for (Map.Entry<String, Map<String, Double>> entry : departmentList.entrySet()) {
            String currenDep = entry.getKey();
            Map<String, Double> value = entry.getValue();
            double sum = 0.0;
            for (Double v : value.values()) {
                sum += v;
            }
            double average = sum / value.size();
            if (currentavg.get() < average) {
                currentavg.set(average);
                departmentHighAVGSalary = currenDep;
            }
        }
        System.out.printf("Highest Average Salary: %s%n", departmentHighAVGSalary);
        peoples.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(peoples);

        for (Employee e : peoples) {
            String currentDepartment = e.getDepartment();

            if (currentDepartment.equals(departmentHighAVGSalary)) {
                System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge());
            }
        }
    }
}
