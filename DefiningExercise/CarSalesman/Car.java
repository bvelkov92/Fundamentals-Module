package src.DefiningExercise.CarSalesman;

public class Car {
    String model;
    String engine;
    String weigh;
    String color;

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getWeigh() {
        return weigh;
    }

    public String getColor() {
        return color;
    }

    // NOT OPTIONAL => model, engine;
    public Car(String model,String engine,String weigh,String color){
        this.model=model;
        this.engine=engine;
        this.weigh = weigh;
        this.color =color;
    }

}
