package vehiclesExtension;

public class Truck extends Vehicle
{
    private final double summerTruckConsumption = 1.6;
    protected Truck(double fuelQuantity, double litersPerKm, double tankCapacity)
    {
        super(fuelQuantity, litersPerKm, tankCapacity);
        this.setLitersPerKm(litersPerKm + summerTruckConsumption);
    }
    @Override
    public String toString()
    {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
