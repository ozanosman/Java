import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MiniMinesweeper
{
    public static int width = 0;
    public static int height = 0;
    public static int mines = 0;

    public static int probes = 0;
    public static int disposals = 0;

    public static final int START_SIGN = 1;
    public static final String ROW_DIVIDER = "-------------------------------------";
    public static final String COL_DIVIDER = " | ";

    public static final String START = "<S>";
    public static final String FINISH = "<F>";
    public static final String EMPTY_SPOT = " X ";

    public static int startX = 0;
    public static int startY = 0;
    public static int finishX = 0;
    public static int finishY = 0;

    public static void main(String[] args)
    {
        readGameBoard();
    }

    private static void readGameBoard()
    {
        File gameBoardFile = new File("resources/enemy_territory");

        try
        {
            FileReader fileReferenceReader1 = new FileReader(gameBoardFile);
            BufferedReader bufferedReader1 = new BufferedReader(fileReferenceReader1);

            String lineReference;
            String wordId;
            int sizeId;

            while ((lineReference = bufferedReader1.readLine()) != null)
            {
                String[] boardIdCollection = lineReference.split(" = ");

                wordId = boardIdCollection[0];
                sizeId = Integer.parseInt(boardIdCollection[1]);

                if (wordId.equals("width"))
                {
                    width = sizeId;
                }

                if (wordId.equals("height"))
                {
                    height = sizeId;
                }

                if (wordId.equals("mines"))
                {
                    mines = sizeId;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String[][] gameBoard = new String[width][height];

        File gameConfigFile = new File("resources/configurations");

        try
        {
            FileReader fileReferenceReader2 = new FileReader(gameConfigFile);
            BufferedReader bufferedReader1 = new BufferedReader(fileReferenceReader2);

            String lineReference;
            String wordId;
            int sizeId;

            while ((lineReference = bufferedReader1.readLine()) != null)
            {
                String[] configIdCollection = lineReference.split(" = ");

                wordId = configIdCollection[0];
                sizeId = Integer.parseInt(configIdCollection[1]);

                if (wordId.equals("number_of_probes"))
                {
                    probes = sizeId;
                }

                if (wordId.equals("number_of_disposals"))
                {
                    disposals = sizeId;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        renderGameBoardElements(gameBoard);
    }

    private static void renderGameBoard(String[][] gameBoard)
    {
        renderRowSigns(gameBoard[0].length);

        System.out.println(ROW_DIVIDER);

        for (int row = 0; row < gameBoard.length; row++)
        {
            System.out.print(START_SIGN + row);
            System.out.print(COL_DIVIDER);

            for (int col = 0; col < gameBoard[row].length; col++)
            {
                System.out.print(gameBoard[row][col]);

                if (col < gameBoard[row].length - 1)
                {
                    System.out.print(COL_DIVIDER);
                }
            }

            System.out.println();
            System.out.println(ROW_DIVIDER);
        }

        renderPlayerInput();
    }

    private static void renderRowSigns(int boardSize)
    {
        System.out.print("    ");

        for (int i = 0; i < boardSize; i++)
        {
            System.out.print(" ");
            System.out.print(START_SIGN + i);
            System.out.print("    ");
        }

        System.out.println();
    }

    // Понякога не ги принтира!
    private static void renderGameBoardElements(String[][] gameBoard)
    {
        Random elementMixer = new Random();

        int startIndex = elementMixer.nextInt(gameBoard.length);
        int finishIndex = elementMixer.nextInt(gameBoard.length);

        int startPosition = elementMixer.nextInt(4);

        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int j = 0; j < gameBoard[i].length; j++)
            {
                if (startIndex == finishIndex)
                {
                    if (finishIndex == 0)
                    {
                        finishIndex += 1;
                    }

                    finishIndex -= 1;
                }

                switch (startPosition)
                {
                    case 1: gameBoard[startIndex][0] = START;
                        startX = startIndex;
                        startY = 0;
                        gameBoard[finishIndex][5] = FINISH;
                        finishX = finishIndex;
                        finishY = 5;
                        break;

                    case 2: gameBoard[0][startIndex] = START;
                        startX = 0;
                        startY = startIndex;
                        gameBoard[5][finishIndex] = FINISH;
                        finishX = 5;
                        finishY = finishIndex;
                        break;

                    case 3: gameBoard[startIndex][5] = START;
                        startX = startIndex;
                        startY = 5;
                        gameBoard[finishIndex][0] = FINISH;
                        finishX = finishIndex;
                        finishY = 0;
                        break;

                    case 4: gameBoard[5][startIndex] = START;
                        startX = 5;
                        startY = startIndex;
                        gameBoard[0][finishIndex] = FINISH;
                        finishX = 0;
                        finishY = finishIndex;
                        break;
                }

                if (gameBoard[i][j] == null)
                {
                    gameBoard[i][j] = EMPTY_SPOT;
                }
            }
        }

        renderGameBoard(gameBoard);
    }

    private static void renderPlayerInput()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("\nВъведете ред: ");
        int inputtedRow = input.nextInt();

        System.out.print("\nВъведете колона: ");
        int inputtedCol = input.nextInt();

        renderUserMenu();
    }

    private static void renderUserMenu()
    {
        System.out.println("\nМеню:" +
                "\n1. Анализ" +
                "\n2. Обезвреждане" +
                "\n3. (пре)Мини");
    }
}
