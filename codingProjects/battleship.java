import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static void setLetter(char letter, int amount, char[][] table){ //function for randomly adding symbols to board
        int row;
        int column;
        int i = 0;
        while(i<amount){ //amount represents how many letters will be added
            row = (int) (Math.random()*6); //picks a random row between 0-5
            column = (int) (Math.random()*5); //picks a random column between 0-4
            if(table[row][column]=='\0'){ //only add letter if spot is empty
                table[row][column] = letter;
                i++;
            } //if spot isn't empty, repeat code (don't increase i)
        }
    }
    
    public static void printGrid(char[][] letterSlots){ //traubian function
        int rowLine = 0, colLine = 0;
        char letter = 'A';
        System.out.print("  |");
        for(int i = 1; i<6;i++){
            System.out.print(i + "\t|");
        }
        System.out.println("");
        while(rowLine != letterSlots.length){ //iterates through rows
            if(letter != 'G'){
                System.out.print(letter + " |");
            }
            while(colLine != letterSlots[rowLine].length){ //iterates through columns
                System.out.print(letterSlots[rowLine][colLine] + "\t|"); //print slot at the current row x column
                colLine++; //go to the next column
            }
            colLine = 0; //go back to the first column after finishing the previous row
            rowLine++; //go to the next row
            letter++;
            System.out.println("");
        }
    }
    
    public static char[][] newGameBoard(){
        char[][]letterSlots=new char[6][5]; //row x column
        
        setLetter('S', 3, letterSlots);
        setLetter('Y', 2, letterSlots);
        setLetter('*', 1, letterSlots);
        
        return letterSlots;
    }
    
    public static int getRow(String loc){
        char row = loc.charAt(1);
        switch (row) {
            case 'A':
            case 'a':
                return 1;
            case 'B':
            case 'b':
                return 2;
            case 'C':
            case 'c':
                return 3;
            case 'D':
            case 'd':
                return 4;
            case 'E':
            case 'e':
                return 5;
            case 'F':
            case 'f':
                return 6;
            default:
                return 10;
        }
        
    }
    
    public static boolean isValid(String x){
        boolean hasTwo = x.length()==2;
        boolean hasLetter = x.matches(".*[a-fA-F].*");
        boolean hasNumber = x.matches(".*[1-5].*");
        return hasLetter && hasNumber && hasTwo;
    }
    
    public static String getValue(Scanner user){
        String x;
        //first condition: check if string is 2 chars long
        //then check if said string has a letter & a number
        //needs to have a Number (1-5)
        //needs to have a letter (A-F)
        while (true){
            x = user.nextLine();
            if (isValid(x)){
                break;
            }
            else{
                System.out.println("Invalid");
            }
        }
        
        //row will always be a letter; make sure it's at second spot
        //col will always be an int; make sure it's at first spot
        String flipped = "" + x.charAt(1) + x.charAt(0);
        if(x.compareTo(flipped)>0){
            return flipped;
        }
        return x;
    }
    
    public static void gameProcession(char[][] letterSlots, char[][] shots){
        Scanner user = new Scanner(System.in);
        char[][]example = new char[6][5];
        int loserCount = 0;
        
        System.out.println("Your task as Admiral is to shoot at locations on a 6 (row) by 5 (column) seaboard. You must detemine what kind of special ship you're aiming for first and make the shot. The special ships include: 3 S's, 2 Y's, and 1 *. If you hit your target, you win the battle. If you hit repeat spots 3 times, you lose the battle!");
        
        while(true){
            
            for(int i = 0; i<=40;i++){
                System.out.print("-");
            }
            System.out.println("");
            printGrid(example);
            
            //USER INPUT
            System.out.println("Make a guess! ");
            System.out.print("Guess for [S], [Y], [*], or [quit]: ");
            String choice = user.next().toUpperCase();
            if(choice.equals("QUIT")){
                System.out.println("you coward\n");
                break;
            }
            char guess = choice.charAt(0);
            user.nextLine();
            
            System.out.print("Location: ");
            String location = getValue(user);
            
            int y = getRow(location);
            int x = location.charAt(0) - '0';
            
            
            //IF STATEMENT - (+) CONDITONAL
            if(shots[y-1][x-1] == '+'){
                loserCount++;
                if(letterSlots[y-1][x-1] == guess){ //
                    System.out.println(ANSI_GREEN + "You sunk my Battleship! " + letterSlots[y-1][x-1] + '\n' + ANSI_RESET);
                    break;
                }
                if(loserCount<3){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(ANSI_RED + "You're on you're way to losing... Loser count: (" + loserCount + "/3)\n" + ANSI_RESET);
                    continue;
                }
                else{
                    System.out.println(ANSI_RED + "YOU LOSE! Loser count: (" + loserCount + "/3)\n" + ANSI_RESET);
                    break;
                }
            }
            
            //IF STATEMENT - UNIQUE CONDITIONAL
            if(letterSlots[y-1][x-1] == '\0'){ //nothing happens if you hit a blank
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Nothing here.\n");
            }
            else{
                if(letterSlots[y-1][x-1] == guess){ //
                    System.out.println(ANSI_GREEN + "You sunk my Battleship! " + letterSlots[y-1][x-1] + '\n' + ANSI_RESET);
                    shots[y-1][x-1] = '+';
                    break;
                }
                else{ //if you hit a special ship, but it's not the SPECIFIED special ship
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("You got the wrong Battleship brah; " + guess + " is not " + letterSlots[y-1][x-1] + '\n');
                }
                
            }
            
            shots[y-1][x-1] = '+';
        }
        
        printGrid(letterSlots);
    }
    
    
    
    public static void main(String[] args){
        char[][]letterSlots= newGameBoard();
        char[][]shots = new char[6][5];
        gameProcession(letterSlots, shots);
    }
}
