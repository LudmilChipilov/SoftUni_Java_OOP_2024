package vehicles;

public class Truck extends Vehicle
{
    private final double summerTruckConsumption = 1.6;

    protected Truck(double fuelQuantity, double litersPerKm)
    {
        super(fuelQuantity, litersPerKm);

        setLitersPerKm(litersPerKm + summerTruckConsumption);
    }

}
