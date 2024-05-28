import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
         Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++)
        {
             items = changeCurrentLight(items);
             printCurrentList(items);
        }
    }
    public static List<String> changeCurrentLight(List<String> items)
    {

        for(int i = 0; i < items.size(); i++)
        {
            Light current = Light.valueOf(items.get(i));
            String str = Light.changeLight(String.valueOf(current));
            items.set(i, str);

        }

        return items;
    }
    public static void printCurrentList(List<String> items)
    {
        System.out.println(String.join(" ", items));
    }
}