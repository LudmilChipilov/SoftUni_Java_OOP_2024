package shoppingSpree;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Person> nameMoney = new ArrayList<>();
        List<Product> productCost = new ArrayList<>();
        try {
            String[] itemsPeople = scanner.nextLine().split(";");
            String[] itemsProducts = scanner.nextLine().split(";");
            nameMoney = addToNameMoneyList(itemsPeople);
            productCost = addToProductCostList(itemsProducts);
            String command = scanner.nextLine();
            while (!command.equals("END"))
            {
                String[] comArgs = command.split(" ");
                String namePerson = comArgs[0];
                String nameProduct = comArgs[1];
                Person person = nameMoney.stream().filter(x -> x.getName().equals(namePerson)).findFirst().orElse(null);
                Product product = productCost.stream().filter(x -> x.getName().equals(nameProduct)).findFirst().orElse(null);
                person.buyProduct(product);
                command = scanner.nextLine();
            }

           }
           catch (IllegalArgumentException iae)
           {
               System.out.println(iae.getMessage());
           }
       for(Person person : nameMoney)
       {
           System.out.println(person.toString());
       }
    }
    public static List<Person> addToNameMoneyList(String[] itemsPeople)
    {
        List<Person> nameMoney = new ArrayList<>();
        for(String people : itemsPeople)
        {
            String[] temp = people.split("=");
            String name = temp[0];
            double money = Double.parseDouble(temp[1]);
            Person person = new Person(name, money);
            nameMoney.add(person);
        }
        return nameMoney;
    }
    public static List<Product> addToProductCostList(String[] itemsProducts)
    {
        List<Product> productCost = new ArrayList<>();
        for(String pr : itemsProducts)
        {
            String[] temp = pr.split("=");
            String name = temp[0];
            double cost = Double.parseDouble(temp[1]);
            Product product = new Product(name, cost);
            productCost.add(product);
        }
        return productCost;
    }

}