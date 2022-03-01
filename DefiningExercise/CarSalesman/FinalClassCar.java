package src.DefiningExercise.CarSalesman;

public class FinalClassCar {
    String carModel;
    String engineModel;
    int enginePower;
    String displacement;
    String efficiency;
    String weigh;
    String color;


    public FinalClassCar(String carModel, String engineModel
            , int enginePower, String displacement, String efficiency, String weigh, String color) {
        this.carModel = carModel;
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.displacement = displacement;
        this.efficiency = efficiency;
        this.weigh = weigh;
        this.color = color;
    }

    @Override
        public String toString() {
            return String.format
                    ("%s:\n%s:\nPower: %d\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s\n",
                            carModel,engineModel,enginePower,displacement
                    ,efficiency,weigh,color);
        }
    }

