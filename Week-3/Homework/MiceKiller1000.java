import java.util.Scanner;
import java.util.Random;

public class MiceKiller1000
{
    public static void main(String[] args)
    {
        combatSystem();
        batteryCheckSystem(0);
        batteryRechargeSystem();
    }

    public static void robotControls()
    {
        Scanner navigation = new Scanner(System.in);
        System.out.println("Какво вижда робота?\n1 за стена\n2 за стол\n3 за нищо");

        loop: while (true)
        {
            int n = navigation.nextInt();
            switch (n)
            {
                case 1: System.out.println("\nGo sideways\n");
                    break loop;

                case 2: System.out.println("\nJump\n");
                    break loop;

                case 3: System.out.println("\nGo forward\n");
                    break loop;

                default: System.out.print("\nНяма такава команда!\nНапишете нова: ");
                    break;
            }
        }
    }

    public static void combatSystem()
    {
        robotControls();

        Scanner pixelCheck = new Scanner(System.in);
        System.out.println("Колко броя пиксели бяха засечени:");
        int pixels = pixelCheck.nextInt();

        boolean targetFound = false;

        for (int i = 0; i < pixels; i++)
        {
            if (pixels % 2 == 0)
            {
                System.out.println("\nTarget detected!\nPreparing to attack!");
                targetFound = true;
                break;
            }
            else
            {
                System.out.print("\nTarget can't be found!\n\nНапишете нов брой пиксели: ");
                pixels = pixelCheck.nextInt();
                i++;
            }
        }

        Scanner attackCheck = new Scanner(System.in);
        System.out.println("\nКой ред атака е това?\nMAX: 4");
        int attacks = attackCheck.nextInt();

        if (attacks <= 4)
        {
            System.out.println("\nReady to attack!");
        }
        else
        {
            System.out.println("\nToo many attacks!\nPowering off!");
            System.exit(0);
        }

        Random rn = new Random();

        int min = 1;
        int max = 10;

        System.out.println("\nГенерира се случайно число от 1 до 10 за атака!");

        int randomNumber = rn.nextInt(max - min) + min;

        System.out.println("Генерираното число е " + randomNumber);

        if (randomNumber != 5)
        {
            System.out.println("\nTarget successfully eliminated!");
            communicationSystem();
        }
        else
        {
            System.out.println("\nWrong target destroyed!");
        }

        switch (attacks)
        {
            case 1: System.out.println("\nCan attack 3 more times!");
                break;

            case 2: System.out.println("\nCan attack 2 more times!");
                break;

            case 3: System.out.println("\nCan attack 1 more time!");
                break;

            case 4: System.out.println("\nLow on power!");
                break;

            default: System.out.println("\nOut of power!\nPowering off!");
                System.exit(0);
        }
    }

    public static void batteryCheckSystem(int attacks)
    {
        do
        {
            Scanner nextCheck = new Scanner(System.in);
            System.out.println("\nИскатели да продължите?\n1 за да\n2 за зареждане\n3 за разговор\n4 за изключване" );
            int nextTarget = nextCheck.nextInt();

            switch (nextTarget)
            {
                case 1: combatSystem();
                    break;

                case 2: batteryRechargeSystem();
                    break;

                case 3: communicationSystem();
                    break;

                case 4: System.out.println("\nPowering off!");
                    System.exit(0);

                default: System.out.print("\nНяма такава команда!\nНапишете нова!\n");
                    break;
            }
        }
        while (attacks <= 4);
    }

    public static void batteryRechargeSystem()
    {
        for (int i = 0; i < 1; i++)
        {
            Random electricUnitA = new Random();
            Random electricUnitB = new Random();

            int min = 1;
            int max = 1000;

            int plugA = electricUnitA.nextInt(max - min) + min;
            int plugB = electricUnitB.nextInt(max - min) + min;

            if (plugA > plugB)
            {
                System.out.print("\nИмаме ток!\nЗареждасе...\n\nЗареждането завърши!\n");
            }
            else
            {
                System.out.print("\nНямаме ток!\nНов опит!\n");
            }
            i++;
        }
    }

    public static void communicationSystem()
    {
        for (int numberCheck = 10; numberCheck > 0; numberCheck--)
        {
            if(numberCheck % 2 == 0)
            {
                System.out.println(numberCheck + ": I am a Robottttt!");
            }
        }
    }
}
