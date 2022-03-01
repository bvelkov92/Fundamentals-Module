package src.Defining.CarInfo;

public class Car {

    public String getBrand() {
        return brand;
    }

    public int getHousePower() {
        return housePower;
    }

    public String brand;
    public String model;
    public int housePower;


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public void setHousePower(int housePower) {
        this.housePower = housePower;
    }

}

