package src.ObjectAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseVehicleCatalogue {

    private static class Vehicles{
        String type;
        String model;
        String color;

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        public int getHorsesPower() {
            return horsesPower;
        }

        int horsesPower;


        public String getModel() {
            return this.model;
        }

        Vehicles(String type, String model, String color, int horsesPower) {
            this.type=type;
            this.model=model;
            this.color=color;
            this.horsesPower = horsesPower;
        }
    }




    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String end = scanner.nextLine();

        List<Vehicles> vehiclesList = new ArrayList<>();


        double averagePowerToCars;
        double averagePowerToTrucks;
        double currentPowerForCars=0;
        double currentPowerForTruck=0;
        double carCounter =0;
        double truckCounter = 0;
         while (!end.equals("End")){

             String [] currentVehicle = end.split(" ");

             String typeVehicle = currentVehicle[0];
             String model = currentVehicle[1];
             String color = currentVehicle[2];
             int horsesPower = Integer.parseInt(currentVehicle[3]);

             if (typeVehicle.equals("truck")){
                 currentPowerForTruck+=horsesPower;
                 truckCounter++;
             }
             else if (typeVehicle.equals("car")){
                 currentPowerForCars+=horsesPower;
                 carCounter++;
             }

             vehicles(vehiclesList,typeVehicle,model,color,horsesPower);

             end= scanner.nextLine();
         }


         String searchCommand = scanner.nextLine();
         while (!searchCommand.equals("Close the Catalogue")) {

             for (int i = 0; i < vehiclesList.size() ; i++) {
                 String type =vehiclesList.get(i).getType();
                 String model = vehiclesList.get(i).getModel();
                 String color =vehiclesList.get(i).getColor();
                 int power = vehiclesList.get(i).getHorsesPower();

                 if (searchCommand.equals(model) && type.equals("truck")){
                     System.out.printf("Type: Truck%nModel: %s%nColor: %s%nHorsepower: %d%n",model,color,power);
                 }
                 else if (searchCommand.equals(model) && type.equals("car")){
                     System.out.printf("Type: Car%nModel: %s%nColor: %s%nHorsepower: %d%n",model,color,power);
                 }
             }
             searchCommand= scanner.nextLine();
         }
        averagePowerToCars = currentPowerForCars/carCounter;
        averagePowerToTrucks = currentPowerForTruck/truckCounter;
        if (carCounter==0){
            averagePowerToCars=0.0;
        }
        if (truckCounter==0){
            averagePowerToTrucks=0.0;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%nTrucks have average horsepower of: %.2f.",averagePowerToCars,averagePowerToTrucks);
         }

    private static void vehicles( List<Vehicles> currentList,String type, String model, String color, int horsesPower){
        Vehicles currentCar = new Vehicles(type,model,color,horsesPower);
        currentList.add(currentCar);
    }
}
