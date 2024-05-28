package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                matrix[i][j] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you"))
        {
            int[] peter = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xE = evil[0];
            int yE = evil[1];

            while (xE >= 0 && yE >= 0)
            {
                if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length)
                {
                    matrix[xE] [yE] = 0;
                }
                xE--;
                yE--;
            }

            int xP = peter[0];
            int yP = peter[1];

            while (xP >= 0 && yP < matrix[1].length)
            {
                if (xP >= 0 && xP < matrix.length && yP >= 0 && yP < matrix[0].length)
                {
                    sum += matrix[xP][yP];
                }

                yP++;
                xP--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }
}
