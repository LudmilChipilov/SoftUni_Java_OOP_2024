package vehiclesExtension;

public class Car extends Vehicle
{
    private final double summerCarConsumption = 0.9;
    protected Car(double fuelQuantity, double litersPerKm, double tankCapacity)
    {
        super(fuelQuantity, litersPerKm, tankCapacity);
        setLitersPerKm(litersPerKm + summerCarConsumption);
    }
    @Override
    public String toString()
    {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
