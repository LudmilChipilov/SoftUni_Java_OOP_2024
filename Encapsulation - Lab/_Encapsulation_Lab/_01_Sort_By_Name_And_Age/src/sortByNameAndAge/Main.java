package sortByNameAndAge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            Person person = new Person(firstName, lastName, age);
            addNewPerson(person,  people);
        }
        people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
        for(Person person : people)
        {
            System.out.println(person.toString());
        }


    }
    public static void addNewPerson(Person person,   List<Person> people)
    {
        people.add(person);
    }
}