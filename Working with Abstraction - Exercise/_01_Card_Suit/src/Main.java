import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Card[] cards = Card.values();
        System.out.println(input + ":");
        for(Card card : cards)
        {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.getValue(), card);
        }

    }
}