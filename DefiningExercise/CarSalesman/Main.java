package src.DefiningExercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int linesPerEngines = Integer.parseInt(scanner.nextLine());

         //FOR ENGINE CLASS
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        List<FinalClassCar> finalList = new ArrayList<>();

         while (linesPerEngines-->0){
             String[] inputLine = scanner.nextLine().split("\\s+");
             //"{Model} {Power} {Displacement} {Efficiency}".

             //OPTIONAL:==> displacement,efficiency;
             Engine engine;
             String model = inputLine[0];
             int power =Integer.parseInt(inputLine[1]);
             if (inputLine.length==2){
                 String displacement = "n/a";
                 String efficiency = "n/a";
                 engine =new Engine(model,power,displacement,efficiency);

             }else if (inputLine.length==4){
                 String displacement =inputLine[2];
                 String efficiency = inputLine[3];
                 engine = new Engine(model,power,displacement,efficiency);

             }else if (inputLine.length==3 && !Character.isLetter(inputLine[2].charAt(0))){
                 String displacement = inputLine[2];
                 String efficiency = "n/a";
                 engine =new Engine(model,power,displacement,efficiency);
             }else {
                 String displacement = "n/a";
                 String efficiency = inputLine[2];
                 engine =new Engine(model,power,displacement,efficiency);
             }
             engineList.add(engine);
         }

         // FOR CAR CLASS
        int linesPerCar = Integer.parseInt(scanner.nextLine());

         while (linesPerCar-->0){
             //"{Model} {Engine} {Weight} {Color}",
             String[] inputLine = scanner.nextLine().split("\\s+");
             String weigh;
             String color;
             //OPTIONAL:==> weigh, color;
             Car car;
             String model = inputLine[0];
             String  power =inputLine[1];
             if (inputLine.length==2){
                  weigh = "n/a";
                  color = "n/a";
                 car=new Car(model,power,weigh,color);

             }else if (inputLine.length==4){
                  weigh =inputLine[2];
                  color = inputLine[3];
                 car = new Car(model,power,weigh,color);

             }else if (inputLine.length==3 && !Character.isLetter(inputLine[2].charAt(0))){
                  weigh = inputLine[2];
                  color = "n/a";
                 car=new Car(model,power,weigh,color);
             }else {
                 color = inputLine[2];
                  weigh = "n/a";
                 car=new Car(model,power,weigh, color);
             }
             carList.add(car);
         }

        //модел кола;
        for (Car car :carList) {
            for (Engine currentEngine :engineList) {
                if (car.getEngine().equals(currentEngine.getEngineModel())){
                    FinalClassCar carWithEngine = new FinalClassCar(car.getModel(), currentEngine.getEngineModel(),
                            currentEngine.getPower(),currentEngine.getDisplacement(), currentEngine.getEfficiency(),
                            car.getWeigh(),car.getColor());
                    finalList.add(carWithEngine);
                }
            }
        }

        for (FinalClassCar car: finalList) {
            System.out.print(car);
        }
         }
    }
