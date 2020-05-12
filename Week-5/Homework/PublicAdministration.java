import java.util.Random;
import java.util.Scanner;

public class PublicAdministration
{
    public static void main(String[] args)
    {
        renderArrayInput();
    }

    public static void renderArrayInput()
    {
        Scanner arrayInput = new Scanner(System.in);
        System.out.println("Въведете броят на числата, които ще се въвеждат: ");
        int arrayLength = arrayInput.nextInt();

        while (arrayLength <= 0)
        {
            System.err.println("\nЧислото трябва да е над 0!\nОпитайте отново!");
            arrayLength = arrayInput.nextInt();
        }

        int[] arraySize = new int[arrayLength];

        System.out.println("\nВъведените числа трябва да са между 0 и 100!");

        for (int i = 0; i < arrayLength; i++)
        {
            System.out.println("Въведете число " + (i + 1) + ":");
            arraySize[i] = arrayInput.nextInt();

            while(arraySize[i] < 0 || arraySize[i] > 100)
            {
                System.err.println("\nВъведеното число е по-малко от 0 или по-голямо от 100!\nОпитайте отново!");
                System.out.println("Въведете число " + (i + 1) + ":");
                arraySize[i] = arrayInput.nextInt();
            }
        }

        renderUserMenuChoices();
        userMenuChoicesInput(arraySize, arrayLength);
    }

    public static void renderUserMenuChoices()
    {
        System.out.println("\nМеню с опции:" +
                "\n1. Сортиране на въведените числа във възходящ ред" +
                "\n2. Сортиране на въведените числа в низходящ ред" +
                "\n3. Търсене на позиция на конкретно число" +
                "\n4. Разбъркване на числата" +
                "\n5. Изчисляване на сбора на всички числа" +
                "\n6. Намиране на най-голямото число" +
                "\n7. Намиране на най-малкото число" +
                "\n8. Намиране средно-аритметично на числата" +
                "\n9. Проверка за симетричност на масива от числа" +
                "\n10. Обръщане на масива от числа" +
                "\n11. Визуализирай въведените числа" +
                "\n12. Изход");
    }

    public static void userMenuChoicesInput(int[] arraySize, int arrayLength)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nИзберете опция:");
        int userChoice = userInput.nextInt();

        switch (userChoice)
        {
            case 1: renderSortedAscendingArray(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 2: renderSortedDescendingArray(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 3: renderSpecificNumber(arraySize, arrayLength, userInput);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 4: renderRandomlyMixedArray(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 5: renderArrayTotal(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 6: renderArrayMax(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 7: renderArrayMin(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 8: renderArraySum(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 9: renderArraySymmetry(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 10: renderArrayReversal(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 11: System.out.println("\nВъведените числа са:");
                renderArray(arraySize, arrayLength);
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
                break;

            case 12: exitProgram();

            default: System.err.println("\nГрешен избор!\nОпитайте отново!");
                renderUserMenuChoices();
                userMenuChoicesInput(arraySize, arrayLength);
        }
    }

    public static void renderContinueOptionAfterChoosing(int[] arraySize, int arrayLength, Scanner userInput)
    {
        System.out.println("\nИскате ли да продължите?\n1 за да\n2 за изход");
        int choice = userInput.nextInt();

        switch (choice)
        {
            case 1: renderUserMenuChoices();
                userMenuChoicesInput(arraySize, arrayLength);
                break;

            case 2: exitProgram();

            default: System.err.println("\nГрешен избор!\nОпитайте отново!");
                renderContinueOptionAfterChoosing(arraySize, arrayLength, userInput);
        }
    }

    public static void renderSortedAscendingArray(int[] arraySize, int arrayLength)
    {
        int temp;

        for (int i = arrayLength - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (arraySize[j] > arraySize[j + 1])
                {
                    temp = arraySize[j];
                    arraySize[j] = arraySize[j + 1];
                    arraySize[j + 1] = temp;
                }
            }
        }

        System.out.println("\nВъведените числа във възходящ ред:");
        renderArray(arraySize, arrayLength);
    }

    public static void renderSortedDescendingArray(int[] arraySize, int arrayLength)
    {
        int temp;

        for (int i = arrayLength - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (arraySize[j] < arraySize[j + 1])
                {
                    temp = arraySize[j];
                    arraySize[j] = arraySize[j + 1];
                    arraySize[j + 1] = temp;
                }
            }
        }

        System.out.println("\nВъведените числа в низходящ ред:");
        renderArray(arraySize, arrayLength);
    }

    public static void renderSpecificNumber(int[] arraySize, int arrayLength, Scanner userInput)
    {
        System.out.println("\nВъведете числото което искате да намерите:");
        int specificNumber = userInput.nextInt();

        int firstIndex = 0;
        int lastIndex = arrayLength - 1;
        int middle = (firstIndex + lastIndex) / 2;
        boolean isNumberFound = false;

        while (firstIndex <= lastIndex)
        {
            if (arraySize[middle] < specificNumber)
            {
                firstIndex = middle + 1;
            }
            else if (arraySize[middle] == specificNumber)
            {
                isNumberFound = true;
                break;
            }
            else
            {
                lastIndex = middle - 1;
            }

            middle = (firstIndex + lastIndex) / 2;
        }

        if (isNumberFound)
        {
            System.out.println("\nТърсеното число " + specificNumber + " е намерено на позиция " + (middle + 1));
        }
        else
        {
            System.out.println("\nТърсеното число " + specificNumber +  " не е намерено");
        }
    }

    public static void renderRandomlyMixedArray(int[] arraySize, int arrayLength)
    {
        Random arrayMixer = new Random();

        for (int i = 0; i < arrayLength; i++)
        {
            int randomIndex = arrayMixer.nextInt(arrayLength);
            int temp = arraySize[i];

            arraySize[i] = arraySize[randomIndex];
            arraySize[randomIndex] = temp;
        }

        System.out.println("\nРазбъркване...\n");
        renderArray(arraySize, arrayLength);
    }

    public static void renderArrayTotal(int[] arraySize, int arrayLength)
    {
        int total = 0;

        for(int i = 0; i < arrayLength; i++)
        {
            total += arraySize[i];
        }

        System.out.println("\nСбора на всички числа e: " + total);
    }

    public static void renderArrayMax(int[] arraySize, int arrayLength)
    {
        int max = arraySize[0];

        for (int i = 0; i < arrayLength; i++)
        {
            if (arraySize[i] > max)
            {
                max = arraySize[i];
            }
        }

        System.out.println("\nНай-голямото число e: " + max);
    }

    public static void renderArrayMin(int[] arraySize, int arrayLength)
    {
        int min = arraySize[0];

        for (int i = 0; i < arrayLength; i++)
        {
            if (arraySize[i] < min)
            {
                min = arraySize[i];
            }
        }

        System.out.println("\nНай-малкото число e: " + min);
    }

    public static void renderArraySum(int[] arraySize, int arrayLength)
    {
        double sum = 0;

        for(int i = 0; i < arrayLength; i++)
        {
            sum += arraySize[i];
        }

        sum = sum / arrayLength;

        System.out.println("\nСредно-аритметично на числата e: " + sum);
    }

    public static void renderArraySymmetry(int[] arraySize, int arrayLength)
    {
        for (int i =0; i < arrayLength; i++)
        {
            if (i > arrayLength / 2)
            {
                System.out.println("\nМасивът е симетричен!");
                renderArray(arraySize, arrayLength);
                break;
            }
            else if (arraySize[i] != arraySize[arrayLength - 1 - i])
            {
                System.out.println("\nМасивът не е симетричен!");
                renderArray(arraySize, arrayLength);
                break;
            }
        }
    }

    public static void renderArrayReversal(int[] arraySize, int arrayLength)
    {
        int temp;

        for (int i = 0; i < arrayLength / 2; i++)
        {
            temp = arraySize[i];
            arraySize[i] = arraySize[arrayLength - i - 1];
            arraySize[arrayLength - i - 1] = temp;
        }

        System.out.println("\nОбръщане...\n");
        renderArray(arraySize, arrayLength);
    }

    public static void renderArray(int[] arraySize, int arrayLength)
    {
        for (int i = 0; i < arrayLength; i++)
        {
            System.out.print(arraySize[i] + " ");
        }

        System.out.println();
    }

    public static void exitProgram()
    {
        System.out.println("\nЗатваря се...");
        System.exit(0);
    }
}