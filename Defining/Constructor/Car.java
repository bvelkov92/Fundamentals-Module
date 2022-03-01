package src.Defining.Constructor;

public class Car {
    String brand;
    String model;
    int housePower;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHousePower() {
        return housePower;
    }

    public Car(String brand, String model, int housePower) {
        this.brand = brand;
        this.model = model;
        this.housePower = housePower;
    }

    public Car(String brand){
       this.brand = brand;
       this.model="unknown";
       this.housePower = -1;
    }
}
