package vehicle;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);





        SportCar sportCar = new SportCar(150, 250);
        sportCar.drive(20);


        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(180, 200);
        raceMotorcycle.drive(15);




        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(190, 160);
        crossMotorcycle.drive(40);

        FamilyCar familyCar = new FamilyCar(100, 90);
        familyCar.drive(30);

    }
}