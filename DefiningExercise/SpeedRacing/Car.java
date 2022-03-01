package src.DefiningExercise.SpeedRacing;

    public class Car {

    //private String carModel;
    private double fuelAmount;
    private final double fuelPerKm;

        public double getFuelAmount() {
            return fuelAmount;
        }

        public double getFuelPerKm() {
            return fuelPerKm;
        }

        public double getDistanceTraveled() {
            return distanceTraveled;
        }

        private double distanceTraveled=Car.STARTING_KILOMETERS;

    public static double STARTING_KILOMETERS=0.0;



    public Car(int fuelAmount,double fuelPerKm){

        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
    }

    public void calculateNeededFuel(double kilometers){
        double neededFuel = kilometers*fuelPerKm;
        if (neededFuel<=fuelAmount){
            this.distanceTraveled+=kilometers;
            this.fuelAmount = this.fuelAmount-neededFuel;
        }else {
            System.out.println(notEnoughFuel());
        }
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %.2f%n",fuelAmount,distanceTraveled);
    }

    private String notEnoughFuel(){
        return String.format("Insufficient fuel for the drive");
}

}
