package firstAndReserveTeam;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.security.InvalidParameterException;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team("Black Eagle");
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++)
        {
            String[] items = scanner.nextLine().split("\\s+");
            try
            {
                String firstName = items[0];
                String lastName = items[1];
                int age = Integer.parseInt(items[2]);
                double salary = Double.parseDouble(items[3]);
                Person person = new Person(firstName, lastName, age, salary);
                team.addPlayer(person);
            }
            catch(InvalidParameterException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }
}