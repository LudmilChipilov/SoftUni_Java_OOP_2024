package vehiclesExtension;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        final double emptyBusFuelConsumption = 1.4;

        String[] carInfo = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        String[] truckInfo = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        String[] busInfo = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));
        int number = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < number; i++)
        {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            if(command.equals("Drive"))
            {
                driveVehicle(commands, car,  truck, bus);
            }
            else if(command.equals("DriveEmpty"))
            {
                driveEmptyBus(commands, bus, emptyBusFuelConsumption);
            }
            else if(command.equals("Refuel"))
            {

                refuelVehicle(commands, car, truck, bus);
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
    public static void driveVehicle(String[] commands, Vehicle car, Vehicle truck, Vehicle bus)
    {
        String vehicleType = commands[1];
        double distance = Double.parseDouble(commands[2]);
        if(vehicleType.equals("Car"))
        {
            car.drive(distance);
        }
        else if(vehicleType.equals("Truck"))
        {
            truck.drive(distance);
        }
        else if(vehicleType.equals("Bus"))
        {
            bus.drive(distance);
        }
    }
    public static void  driveEmptyBus(String[] commands, Vehicle bus, double emptyBusFuelConsumption)
    {
        String vehicleType = commands[1];
        if(vehicleType.equals("Bus"))
        {
            double distance = Double.parseDouble(commands[2]);
            bus.setLitersPerKm(bus.getLitersPerKm() - emptyBusFuelConsumption);
            bus.drive(distance);
            bus.setLitersPerKm(bus.getLitersPerKm() + emptyBusFuelConsumption);
        }

    }
    public static void refuelVehicle(String[] commands, Vehicle car, Vehicle truck, Vehicle bus)
    {
        String vehicleType = commands[1];
        double litersFuel = Double.parseDouble(commands[2]);
        if(vehicleType.equals("Car"))
        {
            car.refuel(litersFuel);
        }
        else if(vehicleType.equals("Truck"))
        {
            truck.refuel(litersFuel*0.95);
        }
        else if(vehicleType.equals("Bus"))
        {
            bus.refuel(litersFuel);
        }
    }
}