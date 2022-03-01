package src.Defining.Constructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
            int numberInputs = Integer.parseInt(scanner.nextLine());

            while (numberInputs-->0){
                String [] inputCarInfo = scanner.nextLine().split("\\s+");

                Car car;
                String brand = inputCarInfo[0];

                if (inputCarInfo.length==1){
                    car = new Car(brand);
                }else {
                    String model = inputCarInfo[1];
                    int housePower = Integer.parseInt(inputCarInfo[2]);
                    car=new Car(brand,model,housePower);
                }

                String output = String.format("The car is: %s %s - %d HP.", car.getBrand(),car.getModel(),car.getHousePower());
                System.out.println(output);
            }
    }
}
