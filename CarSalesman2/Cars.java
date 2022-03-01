package src.CarSalesman2;

public class Cars {

    private String modelCar;
    private String engineModel;
    private String weight;
    private String color;



    public String getModelCar() {
        return modelCar;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }


    public Cars(String modelCar, String engineModel, String weight, String color){
        this.modelCar=modelCar;
        this.engineModel=engineModel;
        this.weight=weight;
        this.color=color;
    }
}
