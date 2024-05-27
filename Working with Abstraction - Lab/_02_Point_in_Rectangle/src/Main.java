import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());
        //{bottomLeftX} {bottomLeftY} {topRightX} {topRightY}
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        for(int i = 0; i < n; i++)
        {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int currentX = arr[0];
            int currentY = arr[1];
            Point point = new Point(currentX, currentY);
            boolean trueOrFalse = rectangle.contains(point);
            System.out.println(trueOrFalse);
        }

    }
}