import java.util.*;
public class TicTacToe
{
    private static char [][] board={{' ', '|', ' ', '|', ' '},
                                    {'-', '+', '-', '+', '-'},
                                    {' ', '|', ' ', '|', ' '},
                                    {'-', '+', '-', '+', '-'},
                                    {' ', '|', ' ', '|', ' '},
                   };
    private static Scanner input= new Scanner(System.in);
    private static String gamemode;
    private static String playAgain;
    private static int pos;
    private static int pos2;
    private static int cPos;
    private static String garbage;
    private static String result;
    private static String name1= "Player";
    private static String name2= "Computer";
    private static ArrayList<Integer> playerPositions= new ArrayList<Integer>();
    private static ArrayList<Integer> player2Positions= new ArrayList<Integer>();
        
    public static void main(String[] args)
    {
        menu();
    }

//------------------------------------------------------------

    public static void menu()
    {
    
        while(true){
            board[0][0]= ' ';
            board[0][2]= ' ';
            board[0][4]= ' ';
            board[2][0]= ' ';
            board[2][2]= ' ';
            board[2][4]= ' ';
            board[4][0]= ' ';
            board[4][2]= ' ';
            board[4][4]= ' ';
        playerPositions = new ArrayList<Integer>(0);
        player2Positions = new ArrayList<Integer>(0);
                System.out.print("\033[H");
                System.out.print("\033[2J");
                System.out.println("TicTacToe\nA. SinglePlayer \nB. Multiplayer");
                gamemode= input.nextLine();
                gamemode= gamemode.toLowerCase();
                gamemode= gamemode.replaceAll("\\s+", "");
                    if(gamemode.equals("a"))
                    {
                        singlePlayer();
                    }else if(gamemode.equals("b")){
                        multiPlayer();
                    }
            }
    }
//------------------------------------------------------------
    
    public static void printBoard()
    {
        System.out.print("\033[H");
        System.out.print("\033[2J");
            
        for(int i= 0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
                System.out.println();
        }
    }

//------------------------------------------------------------

    public static void singlePlayer()
    {
        System.out.print("\033[H");
        System.out.print("\033[2J");
        System.out.println("SinglePlayer");
        System.out.println("What your name?");
        name1= input.nextLine();
        System.out.println("What is your petname for the computer?");
        name2= input.nextLine();
        printBoard();
        System.out.println("Choose a position from 1 - 9");
        while(true)
        {
        pos= input.nextInt();
        
        while(pos<1 || pos>9)
        {
            System.out.println("You cannot go there!");
            pos=input.nextInt();
        }
        while(board[0][0]== 'X' && pos== 1 || board[0][0]=='O' && pos == 1 || board[0][2]== 'X' && pos== 2 || board[0][2]=='O' && pos == 2 || board[0][4]== 'X' && pos== 3 || board[0][4]=='O' && pos == 3 || board[2][0]== 'X' && pos== 4|| board[2][0]=='O' && pos == 4 || board[2][2]== 'X' && pos== 5 || board[2][2]=='O' && pos == 5 || board[2][4]== 'X' && pos== 6 || board[2][4]=='O' && pos == 6 || board[4][0]== 'X' && pos== 7 || board[4][0]=='O' && pos == 7 || board[4][2]== 'X' && pos== 8 || board[4][2]=='O' && pos == 8 || board[4][4]== 'X' && pos== 9 || board[4][4]=='O' && pos == 9)
        {
            System.out.println("You cannot go there!");
            pos=input.nextInt();
        }
            switch(pos)
            {
                case 1: board[0][0]= 'X';
                        break;
                case 2: board[0][2]= 'X';
                        break;
                case 3: board[0][4]= 'X';
                        break;
                case 4: board[2][0]= 'X';
                        break;
                case 5: board[2][2]= 'X';
                        break;
                case 6: board[2][4]= 'X';
                        break;
                case 7: board[4][0]= 'X';
                        break;
                case 8: board[4][2]= 'X';
                        break;
                case 9: board[4][4]= 'X';
                        break;
                default: break;
            }
            playerPositions.add(pos);
            printBoard();
            result = checkWinner();
            System.out.println(result);
            if(result.equals(name1 + " wins!") || result.equals(name2 + " wins!") || result.equals("TIE GAME!"))
            {
                System.out.println("Would you like to play again? (y/n)");
                garbage= input.nextLine();
                playAgain= input.nextLine();
                playAgain= playAgain.toLowerCase();
                playAgain= playAgain.replaceAll("\\s+", "");
                if(playAgain.equals("y"))
                {
                    menu();
                }else if(playAgain.equals("n"))
                {
                    System.exit(0);
                }
            }
            cPos= (int)(9 * Math.random() + 1);
            
            while(board[0][0]== 'X' && cPos== 1 || board[0][0]=='O' && cPos == 1 || board[0][2]== 'X' && cPos== 2 || board[0][2]=='O' && cPos == 2 || board[0][4]== 'X' && cPos== 3 || board[0][4]=='O' && cPos == 3 || board[2][0]== 'X' && cPos== 4|| board[2][0]=='O' && cPos == 4 || board[2][2]== 'X' && cPos== 5 || board[2][2]=='O' && cPos == 5 || board[2][4]== 'X' && cPos== 6 || board[2][4]=='O' && cPos == 6 || board[4][0]== 'X' && cPos== 7 || board[4][0]=='O' && cPos == 7 || board[4][2]== 'X' && cPos== 8 || board[4][2]=='O' && cPos == 8 || board[4][4]== 'X' && cPos== 9 || board[4][4]=='O' && cPos == 9)
            {
               cPos= (int)(9 * Math.random() + 1);
            }
            
            switch(cPos)
            {
                case 1: board[0][0]= 'O';
                        break;
                case 2: board[0][2]= 'O';
                        break;
                case 3: board[0][4]= 'O';
                        break;
                case 4: board[2][0]= 'O';
                        break;
                case 5: board[2][2]= 'O';
                        break;
                case 6: board[2][4]= 'O';
                        break;
                case 7: board[4][0]= 'O';
                        break;
                case 8: board[4][2]= 'O';
                        break;
                case 9: board[4][4]= 'O';
                        break;
                default: break;
            }
            player2Positions.add(cPos);
            printBoard();
            result = checkWinner();
            System.out.println(result);
            if(result.equals(name1 + " wins!") || result.equals(name2 + " wins!") || result.equals("TIE GAME!"))
            {
                System.out.println("Would you like to play again? (y/n)");
                garbage= input.nextLine();
                playAgain= input.nextLine();
                playAgain= playAgain.toLowerCase();
                playAgain= playAgain.replaceAll("\\s+", "");
                if(playAgain.equals("y"))
                {
                    menu();
                }else if(playAgain.equals("n"))
                {
                    System.exit(0);
                }
            }
        }
    }

//------------------------------------------------------------

    public static void multiPlayer()
    {
        System.out.print("\033[H");
        System.out.print("\033[2J");
        System.out.println("MultiPlayer");
        System.out.println("What is player 1's name?");
        name1= input.nextLine();
        System.out.println("What is player 2's name?");
        name2= input.nextLine();
        while(true)
        {
        printBoard();
        System.out.println(name1 + ", enter your position.");
        pos= input.nextInt();
        
            while(pos<1 || pos>9)
            {
                System.out.println("You cannot go there!");
                pos=input.nextInt();
            }
            while(board[0][0]== 'X' && pos== 1 || board[0][0]=='O' && pos == 1 || board[0][2]== 'X' && pos== 2 || board[0][2]=='O' && pos == 2 || board[0][4]== 'X' && pos== 3 || board[0][4]=='O' && pos == 3 || board[2][0]== 'X' && pos== 4|| board[2][0]=='O' && pos == 4 || board[2][2]== 'X' && pos== 5 || board[2][2]=='O' && pos == 5 || board[2][4]== 'X' && pos== 6 || board[2][4]=='O' && pos == 6 || board[4][0]== 'X' && pos== 7 || board[4][0]=='O' && pos == 7 || board[4][2]== 'X' && pos== 8 || board[4][2]=='O' && pos == 8 || board[4][4]== 'X' && pos== 9 || board[4][4]=='O' && pos == 9)
            {
                System.out.println("You cannot go there!");
                pos=input.nextInt();
            }
                switch(pos)
                {
                    case 1: board[0][0]= 'X';
                            break;
                    case 2: board[0][2]= 'X';
                            break;
                    case 3: board[0][4]= 'X';
                            break;
                    case 4: board[2][0]= 'X';
                            break;
                    case 5: board[2][2]= 'X';
                            break;
                    case 6: board[2][4]= 'X';
                            break;
                    case 7: board[4][0]= 'X';
                            break;
                    case 8: board[4][2]= 'X';
                            break;
                    case 9: board[4][4]= 'X';
                            break;
                    default: break;
                }
            playerPositions.add(pos);
            printBoard();
            result= checkWinner();
            System.out.println(result);
            if(result.equals(name1 + " wins!") || result.equals(name2 + " wins!") || result.equals("TIE GAME!"))
            {
                System.out.println("Would you like to play again? (y/n)");
                garbage= input.nextLine();
                playAgain= input.nextLine();
                playAgain= playAgain.toLowerCase();
                playAgain= playAgain.replaceAll("\\s+", "");
                if(playAgain.equals("y"))
                {
                    menu();
                }else if(playAgain.equals("n"))
                {
                    System.exit(0);
                }
            }
            
            System.out.println(name2 + ", enter your position.");
            pos2= input.nextInt();
        
            while(pos2<1 || pos2>9)
            {
                System.out.println("You cannot go there!");
                pos2=input.nextInt();
            }
            while(board[0][0]== 'X' && pos2== 1 || board[0][0]=='O' && pos2 == 1 || board[0][2]== 'X' && pos2== 2 || board[0][2]=='O' && pos2 == 2 || board[0][4]== 'X' && pos2== 3 || board[0][4]=='O' && pos2 == 3 || board[2][0]== 'X' && pos2== 4|| board[2][0]=='O' && pos2 == 4 || board[2][2]== 'X' && pos2== 5 || board[2][2]=='O' && pos2 == 5 || board[2][4]== 'X' && pos2== 6 || board[2][4]=='O' && pos2 == 6 || board[4][0]== 'X' && pos2== 7 || board[4][0]=='O' && pos2 == 7 || board[4][2]== 'X' && pos2== 8 || board[4][2]=='O' && pos2 == 8 || board[4][4]== 'X' && pos2== 9 || board[4][4]=='O' && pos2 == 9)
            {
                System.out.println("You cannot go there!");
                pos2=input.nextInt();
            }
                switch(pos2)
                {
                    case 1: board[0][0]= 'O';
                            break;
                    case 2: board[0][2]= 'O';
                            break;
                    case 3: board[0][4]= 'O';
                            break;
                    case 4: board[2][0]= 'O';
                            break;
                    case 5: board[2][2]= 'O';
                            break;
                    case 6: board[2][4]= 'O';
                            break;
                    case 7: board[4][0]= 'O';
                            break;
                    case 8: board[4][2]= 'O';
                            break;
                    case 9: board[4][4]= 'O';
                            break;
                    default: break;
                }
            player2Positions.add(pos2);
            printBoard();
            result= checkWinner();
            System.out.println(result);
            if(result.equals(name1 + " wins!") || result.equals(name2 + " wins!") || result.equals("TIE GAME!"))
            {
                System.out.println("Would you like to play again? (y/n)");
                garbage= input.nextLine();
                playAgain= input.nextLine();
                playAgain= playAgain.toLowerCase();
                playAgain= playAgain.replaceAll("\\s+", "");
                if(playAgain.equals("y"))
                {
                    menu();
                }else if(playAgain.equals("n"))
                {
                    System.exit(0);
                }
            }
        }
    }
    
//------------------------------------------------------------

    public static String checkWinner()
    {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol= Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol=Arrays.asList(3, 6, 9);
        List rightDiag=Arrays.asList(1, 5, 9);
        List leftDiag =Arrays.asList(7, 5, 3);
        
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(rightDiag);
        winning.add(leftDiag);
        
        for(List l: winning)
        {
            if((playerPositions.containsAll(l) && (playerPositions.size() + player2Positions.size() >=9)) || playerPositions.containsAll(l))
            {
                return name1 + " wins!";
            }else if((player2Positions.containsAll(l) && (playerPositions.size() + player2Positions.size() >=9)) || player2Positions.containsAll(l))
            {
                return name2 + " wins!";
            }
            else if(playerPositions.size() + player2Positions.size() >=9 && !playerPositions.containsAll(l) && !player2Positions.containsAll(l))
            {
                return "TIE GAME!";
            }
        }
        return "";
    }
}