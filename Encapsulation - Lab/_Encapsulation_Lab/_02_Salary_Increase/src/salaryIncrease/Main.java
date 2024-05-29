package salaryIncrease;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++)
        {
            String[] items = scanner.nextLine().split(" ");
            String firstName = items[0];
            String lastName = items[1];
            int age = Integer.parseInt(items[2]);
            double salary = Double.parseDouble(items[3]);
            Person person = new Person(firstName, lastName, age, salary);
            addNewPerson(person, people);
        }
        double percentage = Double.parseDouble(scanner.nextLine());
        printFinalState(people, percentage);
    }
    public static void addNewPerson(Person person,  List<Person> people)
    {
        people.add(person);
    }

    public static void printFinalState(List<Person> people,  double percentage)
    {
        for(Person person : people)
        {
            person.increaseSalary(percentage);
            System.out.printf(person.toString());
        }
    }
}