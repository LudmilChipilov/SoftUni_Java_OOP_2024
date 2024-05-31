package animalFarm;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Chicken
{
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        if(name.equals("") || name.equals(null) || name.equals(" "))
        {
            throw new InvalidParameterException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age)
    {
        if(age < 0 || age > 15)
        {
            throw new InvalidParameterException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
    @Override
    public String toString()
    {
        return String.format("Chicken Chichi (%d) can produce %.2f eggs per day.", age, productPerDay());
    }
    public double productPerDay()
    {
        return calculateProductPerDay();
    }
    private double calculateProductPerDay()
    {
        double result = 0;
        if(age < 6)
        {
            result = 2;
        }
        else if(age < 12)
        {
            result = 1;
        }
        else
        {
            result = 0.75;
        }
        return result;
    }
}
