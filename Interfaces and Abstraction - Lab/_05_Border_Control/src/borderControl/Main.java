package borderControl;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> robots = new ArrayList<>();
        List<Identifiable> citizens = new ArrayList<>();
        String command = scanner.nextLine();
        while(!command.equals("End"))
        {
            String[] comArgs = command.split(" ");
            try
            {
                if(comArgs.length == 3)
                {
                    String name = comArgs[0];
                    int age = Integer.parseInt(comArgs[1]);
                    String id = comArgs[2];
                    Citizen citizen = new Citizen(name, age, id);
                    citizens.add(citizen);
                }
                else if(comArgs.length == 2)
                {
                    String model = comArgs[0];
                    String id = comArgs[1];
                    Robot robot = new Robot(model, id);
                    robots.add(robot);
                }
            }
            catch(IllegalArgumentException iae)
            {
                System.out.println(iae.getMessage());
            }


            command = scanner.nextLine();
        }
        String lastDigits = scanner.nextLine();
        printFinalState(citizens, lastDigits);
        printFinalState(robots, lastDigits);
    }

    public static void printFinalState(List<Identifiable> items,  String lastDigits)
    {
        for(Identifiable item : items)
        {
            if(item.getId().endsWith(lastDigits))
            {
                System.out.println(item.getId());
            }
        }
    }
}