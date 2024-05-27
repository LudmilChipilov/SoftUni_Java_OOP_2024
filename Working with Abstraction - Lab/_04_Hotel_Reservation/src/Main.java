import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] comArgs = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(comArgs[0]);
        int numberOfDays = Integer.parseInt(comArgs[1]);
        String season = comArgs[2].toUpperCase();
        String discount = comArgs[3].toUpperCase();
        discount = getRightValueOfDiscount(discount);
        Season objetSeason = Season.valueOf(season);
        Discount objetDiscount = Discount.valueOf(discount);
        double result = PriceCalculator.calculatePrice(pricePerDay, numberOfDays, objetSeason, objetDiscount);
        System.out.printf("%.2f%n", result);
    }
    public static String getRightValueOfDiscount( String discount)
    {
        if(discount.equals("SECONDVISIT"))
        {
            discount = "SECOND_VISIT";
        }
        return  discount;
    }
}