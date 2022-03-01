package src.CarSalesman2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEngines = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();
        List<Cars> carsList = new ArrayList<>();
        List<FinalClass> finalClassList = new ArrayList<>();

        for (int i = 1; i <= numEngines; i++) {

            List<String> infoForEngine = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

            String displacement = "";
            String efficiency ="";
            String modelEngine = infoForEngine.get(0);
            int power = Integer.parseInt(infoForEngine.get(1));
            if (infoForEngine.size()==3){
                char symbol = infoForEngine.get(2).charAt(0);
               if(!Character.isDigit(symbol)){
                 displacement="n/a";
               }else {
                  displacement=infoForEngine.get(2);
               }
            }else if(infoForEngine.size()<=2){
                displacement="n/a";
            }
            else{
                displacement=infoForEngine.get(2);
            }
            if (infoForEngine.size()==3) {
                char symbol = infoForEngine.get(2).charAt(0);
                if (Character.isDigit(symbol)) {
                    efficiency = "n/a";
                } else {
                    efficiency = infoForEngine.get(2);
                }
            }else if(infoForEngine.size()<=2){
                efficiency="n/a";
            }else {
                efficiency = infoForEngine.get(3);
            }
            Engine currentEngine = new Engine(modelEngine, power, displacement, efficiency);
            engineList.add(currentEngine);
        }

        int numCars = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numCars; i++) {

            List<String> infoForCar = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String weight="";
            String color = "";
            String modelCar = infoForCar.get(0);
            String engine = infoForCar.get(1);
            if (infoForCar.size()==3){
                char symbol = infoForCar.get(2).charAt(0);
                if(!Character.isDigit(symbol)){
                    weight="n/a";
                }else {
                    weight=infoForCar.get(2);
                }
            }else if (infoForCar.size()<=2){
                weight="n/a";
            }
            else {
                weight = infoForCar.get(2);
            }

            if (infoForCar.size()==3){
                char symbol = infoForCar.get(2).charAt(0);
                if(Character.isDigit(symbol)){
                    color="n/a";
                }
                    else {
                    color=infoForCar.get(2);
                }
            }else if (infoForCar.size()<=2){
                color ="n/a";
            } else {
               color = infoForCar.get(3);
            }

            Cars currentCar = new Cars(modelCar, engine, weight, color);
            carsList.add(currentCar);
        }

        for (int i = 0; i < carsList.size(); i++) {
            String currentEngineFromCarList = carsList.get(i).getEngineModel();
            for (int j = 0; j < engineList.size(); j++) {
                String currentEngineFromEngineList = engineList.get(j).getModelEngine();
                if (currentEngineFromCarList.equals(currentEngineFromEngineList)) {

                    String carModel = carsList.get(i).getModelCar();
                    String engineModel = carsList.get(i).getEngineModel();
                    int power = engineList.get(j).getPower();
                    String displacement = engineList.get(j).getDisplacement();
                    String efficiency = engineList.get(j).getEfficiency();
                    String weight = carsList.get(i).getWeight();
                    String color = carsList.get(i).getColor();

                    FinalClass currentVehicle = new FinalClass(carModel, engineModel, power, displacement, efficiency, weight, color);
                    finalClassList.add(currentVehicle);

                }
            }
        }
        for (FinalClass finalClass : finalClassList) {
            System.out.print(finalClass);
        }
    }
}
