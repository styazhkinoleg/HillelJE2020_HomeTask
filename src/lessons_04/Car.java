package lessons_04;

public class Car {
    private double fuelTank;            // max litres
    private double fuelConsumption;     // litres per 100 km
    double fuel;                        // fuel level in litres
    public Car(){

    }
    public Car(double fuelTank, double fuelConsumption){
        this.fuelTank = fuelTank;
        this.fuelConsumption = fuelConsumption;
        this.fuel = this.fuelTank;
    }
    public double fillTank(double fuelLitres){
        double litres = Math.min(fuelLitres, this.fuelTank - this.fuel);
        this.fuel += litres;
        return litres;
    }
    public double getFuelLevelAfterRide(double distance){
        return Math.max(0, this.fuel - this.getLitresNeedToRide(distance));
    }
    public double getLitresNeedToFullTankAfterRide(double distance){
        return this.fuelTank - this.getFuelLevelAfterRide(distance);
    }
    public double getLitresNeedToRide(double distance){
        return distance * this.fuelConsumption / 100;
    }
    public double getDistanceRide(){
        return this.fuel * 100 / this.fuelConsumption;
    }
    public void showInfo(){
        System.out.printf("Fuel tank =        %20.2f litres.\n", this.fuelTank);
        System.out.printf("Fuel consumption = %20.2f litres / 100 km.\n", this.fuelConsumption);
    }
}
