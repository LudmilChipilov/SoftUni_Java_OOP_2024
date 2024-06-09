import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_Enter_Numbers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int previousNumber = 1;
        int count = 10;
        List<String> items = new ArrayList<>();
        while(count > 0)
        {
            try
            {

                int number = Integer.parseInt(scanner.nextLine());

                if(number > 1 && number < 100 && number > previousNumber)
                {
                    items.add(String.valueOf(number));
                    previousNumber = number;
                    count--;
                }
                else
                {
                    System.out.printf("Your number is not in range %d - 100!%n", previousNumber);
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid Number!");
            }
        }
        System.out.println(String.join(", ", items));
    }
}
