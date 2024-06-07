package vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final double truckTinyHole = 0.95;
        String[] carInfo = scanner.nextLine().split("\\s+");
        Vehicle car = createCar(carInfo);
        String[] truckInfo = scanner.nextLine().split("\\s+");
        Vehicle truck = createTruck(truckInfo);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfCommands; i++)
        {
            String[] vehiclesInfo = scanner.nextLine().split("\\s+");
            String command = vehiclesInfo[0];
            String vehicleType = vehiclesInfo[1];
            if(command.equals("Drive"))
            {
                double distance = Double.parseDouble(vehiclesInfo[2]);
                if(vehicleType.equals("Car"))
                {
                    car = driveVehicle(car, distance, vehicleType);
                }
                else if(vehicleType.equals("Truck"))
                {
                    truck = driveVehicle(truck, distance, vehicleType);
                }
            }
            else if(command.equals("Refuel"))
            {
                double liters = Double.parseDouble(vehiclesInfo[2]);
                if(vehicleType.equals("Car"))
                {
                    car = refuelVehicle(car, liters, vehicleType);
                }
                else if(vehicleType.equals("Truck"))
                {
                    truck = refuelVehicle(truck, liters, vehicleType);
                }
            }
        }
        printFinalState(car, truck);
    }
    public static Vehicle createCar(String[] carInfo)
    {
        //Car {fuelQuantity} {litersPerKm}
        double fuelQuantity = Double.parseDouble(carInfo[1]);
        double litersPerKm = Double.parseDouble(carInfo[2]);
        Vehicle car = new Car(fuelQuantity, litersPerKm);
        return car;
    }
    public static Vehicle createTruck(String[] truckInfo)
    {
        //Truck {fuelQuantity} {litersPerKm}
        double fuelQuantity =  Double.parseDouble(truckInfo[1]);
        double litersPerKm = Double.parseDouble(truckInfo[2]);
        Vehicle truck = new Truck(fuelQuantity, litersPerKm);
        return truck;
    }
    public static Vehicle driveVehicle(Vehicle vehicle,  double distance, String vehicleType)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if(vehicle.getFuelQuantity() < distance * vehicle.getLitersPerKm())
        {
            System.out.printf("%s needs refueling%n", vehicleType);
            return vehicle;
        }
        vehicle.setFuelQuantity(vehicle.getFuelQuantity() - distance * vehicle.getLitersPerKm());
        System.out.printf("%s travelled %s km%n", vehicleType, decimalFormat.format(distance));
        return vehicle;
    }
    public static Vehicle refuelVehicle(Vehicle vehicle, double liters, String vehicleType)
    {
        final double truckTinyHole = 0.95;

        if(vehicleType.equals("Truck"))
        {
            liters *= truckTinyHole;
            vehicle.setFuelQuantity(vehicle.getFuelQuantity() + liters);
            return vehicle;
        }
        vehicle.setFuelQuantity(vehicle.getFuelQuantity() + liters);
        return vehicle;
    }
    public static void printFinalState(Vehicle car, Vehicle truck)
    {

        System.out.printf("Car: %.2f%n", (double)car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", (double)truck.getFuelQuantity());
    }
}