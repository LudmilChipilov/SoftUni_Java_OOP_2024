package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

class Pizza
{
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings)
    {
        setName(name);
        setToppings(numberOfToppings);
        toppings = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15)
        {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public String getName() {
        return name;
    }

    public double getOverallCalories() {
        double totalCalories = dough.calculateCalories();
        for (Topping topping : toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }
}