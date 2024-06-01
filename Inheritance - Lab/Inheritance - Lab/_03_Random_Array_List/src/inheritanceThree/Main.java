package inheritanceThree;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        RandomArrayList<String> randomArrayList = new RandomArrayList<>();

        // Adding elements to the RandomArrayList
        randomArrayList.add("Element 1");
        randomArrayList.add("Element 2");
        randomArrayList.add("Element 3");
        randomArrayList.add("Element 4");
        randomArrayList.add("Element 5");

        // Displaying the elements
        try
        {
            System.out.println("Initial List: " + String.join(", ", randomArrayList));

            // Getting and removing a random element
            String randomElement = (String) randomArrayList.getRandomElement();
            System.out.println("Random Element: " + randomElement);

            // Displaying the list after removing the random element
            System.out.println("List after removing the random element: " + String.join(", ", randomArrayList));
        }
        catch(IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
        }

    }
}