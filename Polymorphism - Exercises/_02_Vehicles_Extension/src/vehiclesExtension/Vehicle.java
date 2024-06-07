package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle
{
    private double  fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;
    final double emptyBusFuelConsumption = 1.4;

    protected Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity)
    {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    public void drive(double distance)
    {

        double fuelNeeded = distance * this.litersPerKm;
        if (fuelNeeded <= this.fuelQuantity)
        {
            this.fuelQuantity -= fuelNeeded;
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(distance));
        }
        else
        {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }
    public void refuel(double fuel)
    {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (this.fuelQuantity + fuel > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuel;
        }
    }

}
