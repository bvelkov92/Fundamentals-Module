package src.DefiningExercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine());

        Map<String,Car> carList = new LinkedHashMap<>();

        while (numberCars-->0){
            String [] inputLine= scanner.nextLine().split("\\s+");
            String carModel = inputLine[0];
            int fuelAmount = Integer.parseInt(inputLine[1]);
            double fuelPerKm = Double.parseDouble(inputLine[2]);

            Car car = new Car(fuelAmount,fuelPerKm);
            carList.put(carModel,car);
        }
        String command = scanner.nextLine();

        while (!command.equals("End")){

            String carModel = command.split("\\s+")[1];
            double amountOfKm = Double.parseDouble(command.split("\\s+")[2]);

            carList.get(carModel).calculateNeededFuel(amountOfKm);

            command= scanner.nextLine();
        }
        carList.forEach((key, value) -> System.out.printf
                ("%s %.2f %.0f%n"
                        , key, value.getFuelAmount(), value.getDistanceTraveled()));
    }
}
