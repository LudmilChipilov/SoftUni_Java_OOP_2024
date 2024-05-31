package pizzaCalories;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{

    public static void main(String[] args)
    {
        Pizza pizza;
        try (java.util.Scanner scanner = new java.util.Scanner(System.in))
        {
            String[] pizzaInput = scanner.nextLine().split(" ");
            pizza = createPizza(pizzaInput);
            int numberOfToppings = Integer.parseInt(pizzaInput[2]);
            String[] doughInput = scanner.nextLine().split(" ");
            Dough dough = createDough(doughInput, pizza);

            for (int i = 0; i < numberOfToppings; i++)
            {
                String[] toppingInput = scanner.nextLine().split(" ");
                Topping topping = addTopping(toppingInput, pizza);
            }

            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static Pizza createPizza(String[] pizzaInput)
    {
        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);

         Pizza pizza = new Pizza(pizzaName, numberOfToppings);
         return pizza;
    }
    public static Dough createDough( String[] doughInput, Pizza pizza)
    {
        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double doughWeight = Double.parseDouble(doughInput[3]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);
        return dough;
    }
    public static Topping addTopping(String[] toppingInput, Pizza pizza)
    {
        String toppingType = toppingInput[1];
        double toppingWeight = Double.parseDouble(toppingInput[2]);

        Topping topping = new Topping(toppingType, toppingWeight);
        pizza.addTopping(topping);
        return topping;
    }
}