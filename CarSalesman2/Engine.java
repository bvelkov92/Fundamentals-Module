package src.CarSalesman2;

public class Engine {

    //An Engine has model, power, displacement and efficiency

    String modelEngine;
    int power;
    String displacement;
    String efficiency;

    public String getModelEngine() {
        return modelEngine;
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

    public Engine (String modelEngine,int power,String displacement, String efficiency){
        this.modelEngine = modelEngine;
        this.power = power;
        this.displacement = displacement;
        this.efficiency=efficiency;
    }
}
