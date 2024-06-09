import java.util.Scanner;

public class _02_Square_Root
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            int num = Integer.parseInt(scanner.nextLine());
            if(num >= 0)
            {
                System.out.printf("%.2f%n", Math.sqrt((double) num));
            }
            else
            {
                System.out.println("Invalid");
            }

        }
        catch (Exception ex)
        {
            System.out.println("Invalid");
        }
        finally
        {
            System.out.println("Goodbye");
        }
    }

}
