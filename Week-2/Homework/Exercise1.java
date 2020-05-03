import java.util.Scanner;

public class Exercise1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Въведете страната A на правоъгълника:");
        int a = scanner.nextInt();

        System.out.println("Въведете страната B на правоъгълника:");
        int b = scanner.nextInt();

        rectanglePerimeter(a, b);
        rectangleArea(a, b);
    }

    public static void rectanglePerimeter(int a, int b)
    {
        int perimeter = 2 * (a + b);
        System.out.println("\nПериметъра на правоъгълника е: " + perimeter);
    }

    public static void rectangleArea(int a, int b)
    {
        int area = a * b;
        System.out.println("\nЛицето на правоъгълника е: " + area);
    }
}
