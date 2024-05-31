package shoppingSpree;

import java.security.InvalidParameterException;

public class Product
{
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    private void setName(String name)
    {
        if(name.trim().isEmpty() || name.equals(" "))
        {
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost)
    {
        if(cost < 0)
        {
            throw new InvalidParameterException("Cost cannot be negative");
        }
        this.cost = cost;
    }
}
