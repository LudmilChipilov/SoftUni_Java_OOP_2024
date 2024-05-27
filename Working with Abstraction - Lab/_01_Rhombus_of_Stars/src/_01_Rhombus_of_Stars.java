import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class _01_Rhombus_of_Stars
{

    public static void main(String[] args)
    {
         Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());
         int rowStart = 1;
         int rowEnd = n;
        printRowUpperPart(rowStart, rowEnd, n);
        rowEnd = n - 1;
        printRowLowerPart(rowStart, rowEnd, n);
    }

    public static void printRowUpperPart(int rowStart, int rowEnd, int n)
    {
        for(int row = 1; row <= n; row++)
        {
            printColSpace(1, n - row);   // print whiteSpace
            printColStar(1, row);                // print * And whiteSpace
            System.out.println();
        }
    }
    public static void printRowLowerPart(int rowStart, int rowEnd, int n)
    {
        for(int row = 1; row <= n - 1; row++)
        {
            printColSpace(1, row);                // print whiteSpace
            printColStar(1, n - row);      // print * And whiteSpace
            System.out.println();
        }
    }
    public static void printColSpace(int colStart, int colEnd)
    {
        for(int col = colStart; col <= colEnd; col++)
        {
            System.out.print(" ");
        }
    }
    public static void printColStar(int colStart, int colEnd)
    {
        for(int col = colStart; col <= colEnd; col++)
        {
            System.out.print("*" + " ");
        }
    }
}