package animalFarm;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.security.InvalidParameterException;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken.toString());
        }
        catch(InvalidParameterException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}