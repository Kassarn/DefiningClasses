package p03_SpeedRacing;

public class Car {
    private  String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled= 0;
    }

    public void drive(String model,double amountKm){
        if(this.getFuelAmount() -(this.getFuelCost()*amountKm) >=0){
            this.setFuelAmount(this.getFuelAmount() -(this.getFuelCost()*amountKm));
            this.distanceTraveled+=amountKm;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public String getModel() {
        return model;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String toString() {
       return String.format("%s %.2f %d",this.getModel(),this.getFuelAmount(),this.getDistanceTraveled());
    }
}
