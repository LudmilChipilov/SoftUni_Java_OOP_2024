package restaurant;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        Coffee coffee = new Coffee("Mika", 90.0);
        Tea tea = new Tea("Black", BigDecimal.valueOf(1.00), 300);
        Cake cake = new Cake("Chocolate Cake");

        ColdBeverage coldBeverage = new ColdBeverage("Pepsi", BigDecimal.valueOf(1.50), 350);

        Salmon salmon = new Salmon("Grilled Salmon", BigDecimal.valueOf(12.00));


        Soup soup = new Soup("Chicken Soup", BigDecimal.valueOf(5.00), 300);

    }
}