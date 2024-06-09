import java.util.Arrays;
import java.util.Scanner;

public class _01_Number_in_Range
{
    public static void main(String[] args)
    {
         Scanner scanner = new Scanner(System.in);
        int[] range = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int startNumber = range[0];
        int endNumber = range[1];
        System.out.printf("Range: [%d...%d]%n", startNumber, endNumber);
        while (true)
        {
            String line = scanner.nextLine();
            try
            {
                int number = Integer.parseInt(line);
                if (number >= startNumber && number <= endNumber)
                {
                    System.out.printf("Valid number: %d%n", number);
                    return;
                }
            }
            catch (Exception ex)
            {
                //System.out.println(ex.getMessage());
            }
            System.out.println("Invalid number: " + line);
        }
    }

}