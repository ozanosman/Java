import java.util.Scanner;

public class Exercise2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Въведете месец:");
        String monthName = scanner.nextLine();

        if (monthName.equalsIgnoreCase("Януари"))
        {
            System.out.println("31 дни");
        }
        else if (monthName.equalsIgnoreCase("Февруари"))
        {
            System.out.println("28/29 дни");
        }
        else if (monthName.equalsIgnoreCase("Март"))
        {
            System.out.println("31 дни");
        }
        else if (monthName.equalsIgnoreCase("Април"))
        {
            System.out.println("30 дни");
        }
        else if (monthName.equalsIgnoreCase("Май"))
        {
            System.out.println("31 дни");
        }
        else if (monthName.equalsIgnoreCase("Юни"))
        {
            System.out.println("30 дни");
        }
        else if (monthName.equalsIgnoreCase("Юли"))
        {
            System.out.println("31 дни");
        }
        else if (monthName.equalsIgnoreCase("Август"))
        {
            System.out.println("31 дни");
        }
        else if (monthName.equalsIgnoreCase("Септември"))
        {
            System.out.println("30 дни");
        }
        else if (monthName.equalsIgnoreCase("Октомври"))
        {
            System.out.println("31 дни");
        }
        else if (monthName.equalsIgnoreCase("Ноември"))
        {
            System.out.println("30 дни");
        }
        else if (monthName.equalsIgnoreCase("Декември"))
        {
            System.out.println("31 дни");
        }
        else
        {
            System.out.println("Такъв месец не съществува!");
        }
    }
}
