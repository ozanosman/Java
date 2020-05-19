import java.util.Random;
import java.util.Scanner;

public class PublicAdministrationV2
{
    public static void main(String[] args)
    {
        renderMainMenu();
    }

    public static void renderMainMenu()
    {
        System.out.println("\nГлавно меню с опции:" +
                "\n1. Работа с числа" +
                "\n2. Работа с думи" +
                "\n3. Изход от програмата");

        renderUserMainMenuInput();
    }

    public static void renderUserMainMenuInput()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nИзберете опция:");
        int userChoice = userInput.nextInt();

        switch (userChoice)
        {
            case 1: renderUserIntInput(userInput);
                break;

            case 2: renderUserStringInput(userInput);
                break;

            case 3: exitProgram();

            default: System.err.println("\nГрешен избор!\nОпитайте отново!");
                renderMainMenu();
                renderUserMainMenuInput();
        }
    }


    public static void renderUserIntInput(Scanner userInput)
    {
        System.out.println("\nВъведете броят на числата, които ще се въвеждат:");
        int arrayIntLength = userInput.nextInt();

        while (arrayIntLength <= 0)
        {
            System.err.println("\nЧислото трябва да е над 0!\nОпитайте отново!");
            arrayIntLength = userInput.nextInt();
        }

        int[] arrayIntSize = new int[arrayIntLength];

        System.out.println("\nВъведените числа трябва да са между 0 и 10000!");

        for (int i = 0; i < arrayIntLength; i++)
        {
            System.out.println("Въведете число " + (i + 1) + ":");
            arrayIntSize[i] = userInput.nextInt();

            while(arrayIntSize[i] < 0 || arrayIntSize[i] > 10000)
            {
                System.err.println("\nВъведеното число е по-малко от 0 или по-голямо от 10000!\nОпитайте отново!");
                System.out.println("Въведете число " + (i + 1) + ":");
                arrayIntSize[i] = userInput.nextInt();
            }
        }

        renderSubMenuInt();
        renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
    }

    public static void renderSubMenuInt()
    {
        System.out.println("\nМеню с опции:" +
                "\n1. Извеждане само на простите числа от масива" +
                "\n2. Извеждане на най-често срещан елемент в масива" +
                "\n3. Извеждане на максимална редица от нарастващи елементи в масива" +
                "\n4. Извеждане на максимална редица от намаляващи елементи в масива" +
                "\n5. Извеждане на максимална редица от еднакви елементи в масива" +
                "\n6. Извеждане на последователност от числа от масива, които имат сума\n" +
                "равна на число, генерирано на случаен принцип" +
                "\n7. Връщане назад към основното меню");
    }

    public static void renderUserSubMenuIntInput(Scanner userInput, int[] arrayIntSize, int arrayIntLength)
    {
        System.out.println("\nИзберете опция:");
        int userIntChoice = userInput.nextInt();

        switch (userIntChoice)
        {
            case 1: renderPrimeNumber(arrayIntSize, arrayIntLength);
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
                break;

            case 2: renderMostCommonElement(arrayIntSize, arrayIntLength);
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
                break;

            case 3: renderMaxLongestIncreasingSubsequence(arrayIntSize, arrayIntLength);
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
                break;

            case 4: renderMaxLongestDecreasingSubsequence(arrayIntSize, arrayIntLength);
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
                break;

            case 5: renderMaxLongestEqualSubsequence(arrayIntSize, arrayIntLength);
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
                break;

            case 6: renderRandomNumberEqualSubsequence(arrayIntSize, arrayIntLength);
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
                break;

            case 7: renderMainMenu();
                renderUserMainMenuInput();
                break;

            default: System.err.println("\nГрешен избор!\nОпитайте отново!");
                renderSubMenuInt();
                renderUserSubMenuIntInput(userInput, arrayIntSize, arrayIntLength);
        }
    }

    public static void renderPrimeNumber(int[] arrayIntSize, int arrayIntLength)
    {
        boolean isPrimeNumberFound = true;

        for (int i = 0; i < arrayIntLength; i++)
        {
            for (int j = 2; j <= arrayIntSize[i] / 2; j++)
            {
                if (arrayIntSize[i] % j == 0)
                {
                    isPrimeNumberFound = false;
                    break;
                }
            }

            if (isPrimeNumberFound)
            {
                System.out.println("\n" + arrayIntSize[i] + " е просто число!");
            }
            else
            {
                System.out.println("\n" + arrayIntSize[i] + " не е просто число!");
            }
        }
    }

    public static void renderMostCommonElement(int[] arrayIntSize, int arrayIntLength)
    {
        for (int i = 0; i < arrayIntLength; i++)
        {
            int commonElement = arrayIntSize[i];
            int elementCount = 0;

            for (int j = 0; j < arrayIntLength; j++)
            {
                if (arrayIntSize[j] == commonElement)
                {
                    elementCount++;
                }
            }

            System.out.println("\nНай-често срещаният елемент в масива е " + commonElement + " и се среща " + elementCount + " пъти!");
            break;
        }
    }

    public static void renderMaxLongestIncreasingSubsequence(int[] arrayIntSize, int arrayIntLength)
    {
        int max = 1;
        int counter = 1;
        int maxCount = 0;

        for (int i = 1; i < arrayIntLength; i++)
        {
            if (arrayIntSize[i] > arrayIntSize[i - 1])
            {
                counter++;
            }
            else
            {
                if (max < counter)
                {
                    max = counter;
                    maxCount = i - max;
                }

                counter = 1;
            }
        }

        if (max < counter)
        {
            max = counter;
            maxCount = arrayIntLength - max;
        }

        System.out.println("\nМаксималната редица от нарастващи елементи в масива е:");

        for (int i = maxCount; i < max + maxCount; i++)
        {
            System.out.print(arrayIntSize[i] + " ");
        }

        System.out.println();
    }

    public static void renderMaxLongestDecreasingSubsequence(int[] arrayIntSize, int arrayIntLength)
    {
        int max = 1;
        int counter = 1;
        int maxCount = 0;

        for (int i = 1; i < arrayIntLength; i++)
        {
            if (arrayIntSize[i] < arrayIntSize[i - 1])
            {
                counter++;
            }
            else
            {
                if (max < counter)
                {
                    max = counter;
                    maxCount = i - max;
                }

                counter = 1;
            }
        }

        if (max < counter)
        {
            max = counter;
            maxCount = arrayIntLength - max;
        }

        System.out.println("\nМаксималната редица от намаляващи елементи в масива е:");

        for (int i = maxCount; i < max + maxCount; i++)
        {
            System.out.print(arrayIntSize[i] + " ");
        }

        System.out.println();
    }

    public static void renderMaxLongestEqualSubsequence(int[] arrayIntSize, int arrayIntLength)
    {
        int counter = 1;
        int number = 0;
        int maxCount = 0;

        for (int i = 1; i < arrayIntLength; i++)
        {
            if (arrayIntSize[i] == arrayIntSize[i - 1])
            {
                counter++;

                if (counter > maxCount)
                {
                    maxCount = counter;
                    number = arrayIntSize[i];
                }
            }
            else
            {
                counter = 1;
            }
        }

        System.out.println("\nМаксималната редица от еднакви елементи в масива е:");

        for (int i = 0; i < maxCount; i++)
        {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    public static void renderRandomNumberEqualSubsequence(int[] arrayIntSize, int arrayIntLength)
    {
        boolean isNumberFound = false;

        Random randomNumber = new Random();

        int number = randomNumber.nextInt(100);
        int sum;

        for (int i = 0; i < arrayIntLength; i++)
        {
            sum = arrayIntSize[i];

            for (int j = i + 1; j < arrayIntLength - 1; j++)
            {
                if (sum == number)
                {
                    isNumberFound = true;

                    System.out.print("\nИма сума равна на число, генерирано на случаен принцип: ");

                    for (int k = i; k < j; k++)
                    {
                        System.out.print(arrayIntSize[k] + " ");
                    }

                    System.out.println();
                    break;
                }

                sum += arrayIntSize[j];
            }

            if (isNumberFound)
            {
                break;
            }
        }

        if (!isNumberFound)
        {
            System.out.println("\nНяма сума равна на число, генерирано на случаен принцип!");
        }
    }

    public static void renderUserStringInput(Scanner userInput)
    {
        System.out.println("\nВъведете броят на думите, които ще се въвеждат:");
        int arrayStringLength = userInput.nextInt();

        while (arrayStringLength <= 0)
        {
            System.err.println("\nЧислото трябва да е над 0!\nОпитайте отново!");
            arrayStringLength = userInput.nextInt();
        }

        String[] arrayStringSize = new String[arrayStringLength];

        System.out.println("\nВъведените символи не трябва да са повече от 20!");

        // Тази част на програмата е малко проблемна
        // Трябва да се напише 1+ повече
        // Пример: 3 за две букви

        for (int i = 0; i < arrayStringSize.length; i++)
        {
            arrayStringSize[i] = userInput.nextLine();
            System.out.println("Въведете дума " + (i + 1) + ":");

            while (arrayStringSize[i].length() > 20)
            {
                System.err.println("\nВъведените символи са повече от 20!\nОпитайте отново!");
                arrayStringSize[i] = userInput.nextLine();
                System.out.println("Въведете дума " + (i + 1) + ":");
            }
        }

        renderSubMenuString();
        renderUserSubMenuStringInput(userInput, arrayStringSize);
    }

    public static void renderSubMenuString()
    {
        System.out.println("\nМеню с опции:" +
                "\n1. Обърнете буквите на думите от масива наобратно и ги\n" +
                "визуализирайте в конзолата" +
                "\n2. Изведете броя на повтарящите се символи за всяка една\n" +
                "от думите в масива" +
                "\n3. Изведете броя на символите за всяка една от думите в масива" +
                "\n4. Изведете броя на повтарящите се думи от масива" +
                "\n5. Връщане назад към основното меню");
    }

    public static void renderUserSubMenuStringInput(Scanner userInput, String[] arrayStringSize)
    {
        System.out.println("\nИзберете опция:");
        int userStringChoice = userInput.nextInt();

        switch (userStringChoice)
        {
            case 1: renderReversedLetters(arrayStringSize);
                renderSubMenuString();
                renderUserSubMenuStringInput(userInput, arrayStringSize);
                break;

            case 2: renderRepeatingSymbols(arrayStringSize);
                renderSubMenuString();
                renderUserSubMenuStringInput(userInput, arrayStringSize);
                break;

            case 3: renderCountSymbols(arrayStringSize);
                renderSubMenuString();
                renderUserSubMenuStringInput(userInput, arrayStringSize);
                break;

            case 4: renderRepeatingWords(arrayStringSize);
                renderSubMenuString();
                renderUserSubMenuStringInput(userInput, arrayStringSize);
                break;

            case 5: renderMainMenu();
                renderUserMainMenuInput();
                break;

            default: System.err.println("\nГрешен избор!\nОпитайте отново!");
                renderSubMenuString();
                renderUserSubMenuStringInput(userInput, arrayStringSize);
        }
    }

    public static void renderReversedLetters(String[] arrayStringSize)
    {
        System.out.println("\nОбърнатите букви на думите от масива:");

        for (String letters : arrayStringSize)
        {
            String reverse = new StringBuilder(letters).reverse().toString();
            System.out.print(reverse + " ");
        }

        System.out.println();
    }

    public static void renderRepeatingSymbols(String[] arrayStringSize)
    {
        int count = 1;

        for(int i = 0; i < arrayStringSize.length; i++)
        {
            for(int j = 0; j < arrayStringSize[i].length(); j++)
            {
                for(int k = j + 1; k < arrayStringSize[i].length(); k++)
                {
                    if (arrayStringSize[i].charAt(j) == (arrayStringSize[i].charAt(k)))
                    {
                        char symbol = 0;

                        count++;
                        arrayStringSize[i].replace(arrayStringSize[i].charAt(j), symbol);
                    }
                }

                if (count != 1)
                {
                    System.out.println("\n" + arrayStringSize[i] + " - брой повторения: " + count + " - " + arrayStringSize[i].charAt(j));
                }

                count = 1;
            }
        }
    }

    public static void renderCountSymbols(String[] arrayStringSize)
    {
        int[] countSymbols = new int[arrayStringSize.length];

        for (int i = 0; i < arrayStringSize.length; i++)
        {
            countSymbols[i] = arrayStringSize[i].length();
        }
        for (int i = 0; i < arrayStringSize.length; i++)
        {
            System.out.println("\n" + arrayStringSize[i] + " - брой символи: " + countSymbols[i]);
        }
    }

    public static void renderRepeatingWords(String[] arrayStringSize)
    {
        int count = 1;

        for (int i = 0; i < arrayStringSize.length; i++)
        {
            if (arrayStringSize[i] != null)
            {
                for (int j = i + 1; j < arrayStringSize.length; j++)
                {
                    if (arrayStringSize[j] != null)
                    {
                        if (arrayStringSize[i].toLowerCase().equals(arrayStringSize[j].toLowerCase()))
                        {
                            count++;
                            arrayStringSize[j] = null;
                        }
                    }
                }

                System.out.println(arrayStringSize[i] + " – брой повторения: " + count);
                count = 1;
            }
        }
    }

    private static void exitProgram()
    {
        System.out.println("\nЗатваря се...");
        System.exit(0);
    }
}