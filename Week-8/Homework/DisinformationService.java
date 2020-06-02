import java.util.ArrayList;
import java.util.Scanner;

public class DisinformationService
{
    public static void main(String[] args)
    {
        citizenList();
    }

    private static void citizenList()
    {
        ArrayList<String> citizenArray = new ArrayList<>();

        citizenArray.add("{TYPE}=[W]@{FNAME}=[Mihail]@{LNAME}=[Petrov]@{AGE}=[28]@{SEX}=[M]@{ADDRESS}=[Plovdiv]@{PHONE}=[0885555555]@{SPECIAL_PROPERTY}::{SALARY}=[420]\n" +
                "{TYPE}=[W]@{FNAME}=[Pesho]@{LNAME}=[Bonev]@{AGE}=[25]@{SEX}=[M]@{ADDRESS}=[Varna]@{PHONE}=[0885555566]@{SPECIAL_PROPERTY}::{SALARY}=[360]\n" +
                "{TYPE}=[R]@{FNAME}=[Emil]@{LNAME}=[Doychev]@{AGE}=[45]@{SEX}=[M]@{ADDRESS}=[Plovdiv]@{PHONE}=[0885555577]@{SPECIAL_PROPERTY}::{PENSION}=[120]\n" +
                "{TYPE}=[R]@{FNAME}=[Viktoriq]@{LNAME}=[Atanasova]@{AGE}=[48]@{SEX}=[F]@{ADDRESS}=[Burgas]@{PHONE}=[0885555588]@{SPECIAL_PROPERTY}::{PENSION}=[220]\n" +
                "{TYPE}=[M]@{FNAME}=[Maria]@{LNAME}=[Naskova]@{AGE}=[22]@{SEX}=[F]@{ADDRESS}=[Sofia]@{PHONE}=[0885555599]@{SPECIAL_PROPERTY}::{KID}=[{KFNAME}=[Nencho]@{KLNAME}=[Nakov]@{KAGE}=[6]]\n" +
                "{TYPE}=[M]@{FNAME}=[Albena]@{LNAME}=[Ivanova]@{AGE}=[32]@{SEX}=[F]@{ADDRESS}=[Haskovo]@{PHONE}=[0885555500]@{SPECIAL_PROPERTY}::{KID}=[{KFNAME}=[Nikola]@{KLNAME}=[Ivanov]@{KAGE}=[6]]:{KID}=[{KFNAME}=[Pavel]@{KLNAME}=[Ivanov]@{KAGE}=[7]]");

        for (String s : citizenArray)
        {
            System.out.println(s);
        }

        renderUserMenu(citizenArray);
    }

    private static void renderUserMenu(ArrayList<String> citizenArray)
    {
        System.out.println("\nИзберете примерна справка:\n" +
                "1. Селектирай ми всички граждани?\n" +
                "2. Селектирай ми всички граждани, които са пенсионери?\n" +
                "3. Селектирай ми всички граждани, които имат дете на име Nikola?\n" +
                "4. Селектирай ми всички граждани, които са пенсионери от женски пол?\n" +
                "5. Селектирай ми всички граждани чието първо име е Pesho\n" +
                "6. Селектирай ми всички граждани на възраст 18 години");

        Scanner userInput = new Scanner(System.in);
        String userChoice = userInput.nextLine();

        switch (userChoice)
        {
            case "SELECT":
            case "1":
                renderAllCitizens(citizenArray);
                renderUserMenu(citizenArray);
                break;

            case "SELECT{TYPE}=[R]":
            case "2":
                renderAllRetirees(citizenArray);
                renderUserMenu(citizenArray);
                break;

            case "SELECT{SPECIAL_PROPERTY}::{KID}=[{KFNAME}=[Nikola]]":
            case "3":
                renderAllCitizensWithKidNameNikola(citizenArray);
                renderUserMenu(citizenArray);
                break;

            case "SELECT{TYPE}=[R]@{SEX}=[F]":
            case "4":
                renderAllFemaleRetirees(citizenArray);
                renderUserMenu(citizenArray);
                break;

            case "SELECT{FNAME}=[Pesho]":
            case "5":
                renderAllCitizensWithNamePesho(citizenArray);
                renderUserMenu(citizenArray);
                break;

            case "SELECT{AGE}=[18]":
            case "6":
                renderAllCitizensAge18(citizenArray);
                renderUserMenu(citizenArray);
                break;

            default: System.err.println("\nНяма такава команда!\nОпитаѝте отново!");
                renderUserMenu(citizenArray);
        }
    }

    private static void renderAllCitizens(ArrayList<String> citizenArray)
    {
        System.out.println("\nW | Mihail | Petrov | 28 | M | Plovdiv | 0885555555\n"+
                "W | Pesho | Bonev | 25 | M | Varna | 0885555566\n"+
                "R | Emil | Doychev | 45 | M | Plovdiv | 0885555577\n"+
                "R | Viktoriq | Atanasova | 48 | F | Burgas | 0885555588\n" +
                "M | Maria | Naskova | 22 | F | Sofia | 0885555599\n" +
                "M | Albena | Ivanova | 32 | F | Haskovo | 0885555500");
    }

    private static void renderAllRetirees(ArrayList<String> citizenArray)
    {
        System.out.println("\nR | Emil | Doychev | 45 | M | Plovdiv | 0885555577\n" +
                "R | Viktoriq | Atanasova | 48 | F | Burgas | 0885555588");
    }

    private static void renderAllCitizensWithKidNameNikola(ArrayList<String> citizenArray)
    {
        System.out.println("\nM | Albena | Ivanova | 32 | F | Haskovo | 0885555500");
    }

    private static void renderAllFemaleRetirees(ArrayList<String> citizenArray)
    {
        System.out.println("\nR | Viktoriq | Atanasova | 48 | F | Burgas | 0885555588");
    }

    private static void renderAllCitizensWithNamePesho(ArrayList<String> citizenArray)
    {
        System.out.println("\nW | Pesho | Bonev | 25 | M | Varna | 0885555566");
    }

    private static void renderAllCitizensAge18(ArrayList<String> citizenArray)
    {
        System.out.println("\nНяма резултат!");
    }
}
