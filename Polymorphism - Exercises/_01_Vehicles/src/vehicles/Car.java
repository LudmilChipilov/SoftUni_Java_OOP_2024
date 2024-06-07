package vehicles;

public class Car extends Vehicle
{
    private final double summerCarConsumption = 0.9;
    protected Car(double fuelQuantity, double litersPerKm)
    {
        super(fuelQuantity, litersPerKm);
        setLitersPerKm(litersPerKm + summerCarConsumption);
    }



}
