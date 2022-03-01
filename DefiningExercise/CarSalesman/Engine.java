package src.DefiningExercise.CarSalesman;

public class Engine {

    String engineModel;
    int power;
    String displacement;
    String efficiency;

    public String getEngineModel() {
        return engineModel;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
// NOT OPTIONAL=> model, power
    //efficiency
    //displacement

    public Engine(String model,int power,String displacement,String efficiency){
        this.engineModel =model;
        this.power =power;
        this.displacement =displacement;
        this.efficiency = efficiency;
    }

}
