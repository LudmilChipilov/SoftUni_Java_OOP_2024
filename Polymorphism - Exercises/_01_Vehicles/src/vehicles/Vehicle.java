package vehicles;

public abstract class Vehicle
{
    private double  fuelQuantity;
    private double litersPerKm;

    protected Vehicle(double fuelQuantity, double litersPerKm)
    {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    protected void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

}
