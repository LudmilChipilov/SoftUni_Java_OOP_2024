package shapes;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Shape rectangle = new Rectangle(5.0, 6.0);
        Shape circle = new Circle(5.0);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}