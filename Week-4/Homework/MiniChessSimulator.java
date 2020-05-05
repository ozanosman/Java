import java.util.Scanner;

public class MiniChessSimulator
{
    public static void main(String[] args)
    {
        String[][] gameBoard = {{"wDw", " ", "wD", " ", "wQ", " ", "wK", " ", "wM", " ", "wDw", " ", "A"},
                {" 0 ", " ", "0 ", " ", "0 ", " ", " 0", " ", " 0", " ", " 0 ", " ", "B"},
                {" 0 ", " ", "0 ", " ", "0 ", " ", " 0", " ", " 0", " ", " 0 ", " ", "C"},
                {" 0 ", " ", "0 ", " ", "0 ", " ", " 0", " ", " 0", " ", " 0 ", " ", "D"},
                {" 0 ", " ", "0 ", " ", "0 ", " ", " 0", " ", " 0", " ", " 0 ", " ", "E"},
                {"bDw", " ", "bM", " ", "bK", " ", "bQ", " ", "wD", " ", "bDw", " ", "F"},
                {" A ", " ", "B ", " ", "C ", " ", " D", " ", " E", " ", " F "}};

        int round = 0;

        Scanner playerInputScanner = new Scanner(System.in);
        System.out.println("Choose your side!\n1 for white side\n2 for black side\n3 to quit the game");

        while (true)
        {
            int playerSide = playerInputScanner.nextInt();

            switch (playerSide)
            {
                case 1: whitePlayer(gameBoard, round);
                    break;

                case 2: blackPlayer(gameBoard, round);
                    break;

                case 3: System.out.println("\nClosing game...");
                    System.exit(0);

                default: System.out.println("\nTry again!\n");
                    break;
            }
        }
    }

    public static void renderGameBoard(String[][] gameBoard)
    {
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = 0; col < gameBoard[row].length; col++)
            {
                System.out.print(gameBoard[row][col]);
            }

            System.out.println();
        }
    }

    public static void whitePlayer(String[][] gameBoard, int round)
    {
        renderGameBoard(gameBoard);

        round++;
        System.out.print("\nRound: " + round);

        Scanner whitePieceInputScanner = new Scanner(System.in);
        System.out.println("\nWhite player's turn!\n\nInput row and column of the piece you wish to move:\nPlease use capital letters!");

        String whitePlayerPieceSelect = whitePieceInputScanner.nextLine();

        switch (whitePlayerPieceSelect)
        {
            case "AA": gameBoard[0][0] = "   ";
                System.out.println("\nYou choose the White Dwarf\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "AB": gameBoard[0][2] = "  ";
                System.out.println("\nYou choose the White Donkey\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "AC": gameBoard[0][4] = "  ";
                System.out.println("\nYou choose the White Queen\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "AD": gameBoard[0][6] = "  ";
                System.out.println("\nYou choose the White King\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "AE": gameBoard[0][8] = "  ";
                System.out.println("\nYou choose the White Machine Gun\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "AF": gameBoard[0][10] = "   ";
                System.out.println("\nYou choose the White Dwarf\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            default: System.out.println("\nTurn lost!\n");
                blackPlayer(gameBoard, round);
                break;
        }

        String whitePlayerPiecePlacement = whitePieceInputScanner.nextLine();

        switch (whitePlayerPiecePlacement)
        {
            case "BA": gameBoard[1][0] = "wDw";
                break;

            case "BB": gameBoard[1][2] = "wD";
                break;

            case "BC": gameBoard[1][4] = "wQ";
                break;

            case "BD": gameBoard[1][6] = "wK";
                break;

            case "BE": gameBoard[1][8] = "wM";
                break;

            case "BF": gameBoard[1][10] = "wDw";
                break;

            default: System.out.println("\nTurn lost!\n");
                blackPlayer(gameBoard, round);
                break;
        }

        blackPlayer(gameBoard, round);
    }

    public static void blackPlayer(String[][] gameBoard, int round)
    {
        renderGameBoard(gameBoard);

        round++;
        System.out.print("\nRound: " + round);

        Scanner blackPieceInputScanner = new Scanner(System.in);
        System.out.println("\nBlack player's turn!\n\nInput row and column of the piece you wish to move:\nPlease use capital letters!");

        String blackPlayerPieceSelect = blackPieceInputScanner.nextLine();

        switch (blackPlayerPieceSelect)
        {
            case "FA": gameBoard[5][0] = "   ";
                System.out.println("\nYou choose the Black Dwarf\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "FB": gameBoard[5][2] = "  ";
                System.out.println("\nYou choose the Black Machine Gun\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "FC": gameBoard[5][4] = "  ";
                System.out.println("\nYou choose the Black King\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "FD": gameBoard[5][6] = "  ";
                System.out.println("\nYou choose the Black Queen\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "FE": gameBoard[5][8] = "  ";
                System.out.println("\nYou choose the Black Donkey\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            case "FF": gameBoard[5][10] = "   ";
                System.out.println("\nYou choose the Black Dwarf\n\nInput row and column of where you wish to move the piece:\nPlease use capital letters!");
                break;

            default: System.out.println("\nTurn lost!\n");
                whitePlayer(gameBoard, round);
                break;
        }

        String blackPlayerPiecePlacement = blackPieceInputScanner.nextLine();

        switch (blackPlayerPiecePlacement)
        {
            case "EA": gameBoard[4][0] = "bDw";
                break;

            case "EB": gameBoard[4][2] = "bD";
                break;

            case "EC": gameBoard[4][4] = "bQ";
                break;

            case "ED": gameBoard[4][6] = "bK";
                break;

            case "EE": gameBoard[4][8] = "bM";
                break;

            case "EF": gameBoard[4][10] = "bDw";
                break;

            default: System.out.println("\nTurn lost!\n");
                whitePlayer(gameBoard, round);
                break;
        }

        whitePlayer(gameBoard, round);
    }
}
