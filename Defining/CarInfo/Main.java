package src.Defining.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int number = Integer.parseInt(scanner.nextLine());
        Car newCar;
         while (number-->0) {
             String[] currentCar = scanner.nextLine().split("\\s+");
             String brand = currentCar[0];
             String model = currentCar[1];
             int housePower = Integer.parseInt(currentCar[2]);
             newCar=new Car();
             newCar.setBrand(brand);
             newCar.setModel(model);
             newCar.setHousePower(housePower);

             String output = String.format("The car is: %s %s - %s HP.",newCar.getBrand(),newCar.getModel(),newCar.getHousePower());
             System.out.println(output);
         }

    }
}
