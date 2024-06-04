package foodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int totalFood = 0;
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Citizen> citizens = new LinkedHashMap<>();
        Map<String, Rebel> rebels = new LinkedHashMap<>();
        for(int i = 0; i < numberOfPeople; i++)
        {
            String[] items = scanner.nextLine().split("\\s+");
            if(items.length == 4)
            {
                  citizens = addCitizenToMap(citizens, items);
            }
            else if(items.length == 3)
            {
                  rebels = addRebelToMap(rebels, items);
            }
        }
        String command = scanner.nextLine();
        while(!command.equals("End"))
        {
            String name = command;
            if(citizens.containsKey(name))
            {
                Citizen citizen = citizens.get(name);
                citizen.buyFood();
                totalFood += citizen.getFood();
                citizen.setFood(0);
            }
            else if(rebels.containsKey(name))
            {
                Rebel rebel = rebels.get(name);
                rebel.buyFood();
                totalFood += rebel.getFood();
                rebel.setFood(0);
            }
            command = scanner.nextLine();
        }
        System.out.println(totalFood);
    }
   public static Map<String, Citizen> addCitizenToMap(Map<String, Citizen> citizens, String[] items)
   {
       //{name} {age} {id} {birthdate}
       String name = items[0];
       int age = Integer.parseInt(items[1]);
       String id = items[2];
       String birthdate = items[3];
       if(citizens.isEmpty() || !citizens.containsKey(name))
       {
           Citizen citizen = new Citizen(name, age, id, birthdate);
           citizens.put(name, citizen);
       }
       return citizens;
   }
    public static Map<String, Rebel> addRebelToMap(Map<String, Rebel> rebels, String[] items)
    {
        //{name} {age}{group}
        String name = items[0];
        int age = Integer.parseInt(items[1]);
        String group = items[2];

        if(rebels.isEmpty() || !rebels.containsKey(name))
        {
            Rebel rebel = new Rebel(name, age, group);
            rebels.put(name, rebel);
        }
        return rebels;
    }
}