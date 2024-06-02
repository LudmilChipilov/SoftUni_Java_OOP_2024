package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalsList = new ArrayList<>();
        while (true) {
            String animalType = scanner.nextLine();
            if (animalType.equals("Beast!")) {
                break;
            }
            String[] animalInfo = scanner.nextLine().split("\\s+");
            try {
                String name = animalInfo[0];
                int age = Integer.parseInt(animalInfo[1]);
                String gender = animalInfo[2];
                if((checkIfAnimalTypeIsValid(animalType)))
                {
                    animalsList = addAnimalToList(animalsList, animalType, animalInfo);
                }
                else
                {
                    throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }

       printFinalState(animalsList);
    }
    public static boolean checkIfAnimalTypeIsValid( String animalType)
    {
        if(animalType.equals("Dog") || animalType.equals("Frog") || animalType.equals("Cat") ||
                animalType.equals("Kitten") || animalType.equals("Tomcat"))
        {
            return true;
        }
        return false;
    }
    public static List<Animal> addAnimalToList(List<Animal> animalsList,  String animalType,  String[] animalInfo)
    {
        String name = animalInfo[0];
        int age = Integer.parseInt(animalInfo[1]);
        String gender = animalInfo[2];
        if (animalType.equals("Dog"))
        {
            animalsList.add(new Dog(name, age, gender));
        }
        else if (animalType.equals("Frog"))
        {
            animalsList.add(new Frog(name, age, gender));
        }
        else if (animalType.equals("Cat"))
        {
            animalsList.add(new Cat(name, age, gender));
        } else if (animalType.equals("Kitten"))
        {
            animalsList.add(new Kitten(name, age));
        }
        else if (animalType.equals("Tomcat"))
        {
            animalsList.add(new Tomcat(name, age));
        }
        return animalsList;
    }
    public static void printFinalState(List<Animal> animalsList)
    {
        for (Animal animal : animalsList)
        {
            System.out.println(animal.toString());
        }
    }
}