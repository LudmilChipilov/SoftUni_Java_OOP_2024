package classBox;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.security.InvalidParameterException;
import java.util.Scanner;
import java.io.IOException;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        //length, width, and height
        try
        {
            double length  = Double.parseDouble(scanner.nextLine());
            double  width = Double.parseDouble(scanner.nextLine());
            double height  = Double.parseDouble(scanner.nextLine());
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume – %.2f%n", box.calculateVolume());
        }
        catch (InvalidParameterException ex)
        {
            System.out.println(ex.getMessage());
        }


    }
}