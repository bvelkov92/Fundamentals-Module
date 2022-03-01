package src.CarSalesman2;

public class FinalClass {

    String carModel;
    String engineModel;
    int power;
    String displacement;
    String efficiency;
    String weight;
    String color;

    FinalClass(String carModel,String engineModel,int power, String displacement, String efficiency, String weight, String color){
        this.carModel=carModel;
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                        "  %s:%n" +
                        "    Power: %d%n" +
                        "    Displacement: %s%n" +
                        "    Efficiency: %s%n" +
                        "  Weight: %s%n" +
                        "  Color: %s%n",this.carModel,this.engineModel,this.power,
                this.displacement,this.efficiency,this.weight,this.color);
    }
}
