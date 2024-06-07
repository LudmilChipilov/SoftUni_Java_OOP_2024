package vehiclesExtension;

public class Bus extends Vehicle
{
    private  final double summerTruckConsumption = 1.4;
    protected Bus(double fuelQuantity, double litersPerKm, double tankCapacity)
    {
        super(fuelQuantity, litersPerKm, tankCapacity);
        this.setLitersPerKm(litersPerKm + summerTruckConsumption);
    }
    @Override
    public String toString()
    {
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
