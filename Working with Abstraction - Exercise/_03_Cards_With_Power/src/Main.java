import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String inputRank = scanner.nextLine();
        String inputSuit = scanner.nextLine();
        RankPower rp = RankPower.valueOf(inputRank);
        SuitPower sp = SuitPower.valueOf(inputSuit);
        System.out.printf("Card name: %s of %s; Card power: %d",
                inputRank, inputSuit, rp.getValue() + sp.getValue());
    }
}