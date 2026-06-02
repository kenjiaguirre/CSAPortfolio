import java.util.Scanner;
public class Funtime{
    
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String reset = "\u001B[0m";
    
    public static int[][] setGrid(){
        int counter = 1;
        int[][]arr = new int[10][10];
        for(int row = 0; row<=9; row++){ //iterate through each row
            for(int col = 0; col<=9; col++){ //iterate through each column
                arr[row][col]=counter; //print number at row x col
                counter++; //go to next col
            }
        }
        return arr;
    }
    
    public static void printGrid(int[][] arr){
        for(int i = 0; i<=9; i++){ //iterate through each row
            for(int k = 0; k<=9; k++){ //iterate through each col
                System.out.printf("%5d",arr[i][k]); //prints a formatted slot
            }
            System.out.println(""); //prints to next line
        }
    }
    
    public static void printBoolGrid(boolean[][] arr){
        for(int i = 0; i<=9; i++){ //iterate through each row
            for(int k = 0; k<=9; k++){ //iterate through each col
                if(arr[i][k] == false){
                    System.out.print(red + arr[i][k] + reset + " "); //prints a formatted slot
                }
                else{
                    System.out.print(green + arr[i][k] + reset + " "); //prints a formatted slot
                }
            }
            System.out.println(""); //prints to next line
        }
    }
    
    public static void level1(int[][] arr, boolean[][]bools){
        System.out.println("Level 1");
        for(int row = 0; row<=9; row++){ //iterate through each row
            for(int col = 0; col<=9; col++){ //iterate through each col
                if (arr[row][col]%5==0 && bools[row][col] == false){ //if mult of 5
                    arr[row][col] = arr[row][col]/5; //divide by 5
                    bools[row][col]=true;
                }
            }
        }
    }
    
    public static void level2(int[][] arr, boolean[][]bools){
        System.out.println("Level 2");
        for(int row = 0; row<=9; row++){ //iterate through each row
            for(int col = 0; col<=9; col++){ //iterate through each col
                if(arr[row][col]%11==0 && bools[row][col] == false){ //if number repeats (essentially mult of 11):
                    arr[row][col] = arr[row][col]/11; //divide by 11 to make it single
                    bools[row][col]=true;
                }
            }
        }
    }
    
    public static void level3(int[][] arr, boolean[][]bools){
        System.out.println("Level 3");
        for(int row = 0; row<=9; row++){ //iterate through each row
            for(int col = 0; col<=9; col++){ //iterate through each col
                if(arr[row][col]%2==0 && bools[row][col] == false){ //if multiple of 2:
                    String temp = String.valueOf(arr[row][col]) + "0"; //set to string to append 0
                    arr[row][col] = Integer.parseInt(temp); //turn back to int
                    bools[row][col]=true;
                }
            }
        }
    }
    
    public static void level4(int[][] arr, boolean[][]bools){
        System.out.println("Level 4");
        for(int row = 0; row<=9; row++){ //iterate through each row
            for(int col = 0; col<=9; col++){ //iterate through each col
                if(arr[row][col]%3==0 && bools[row][col] == false){ //if multiple of 3:
                    int rando = (int)(Math.random()*6); //sets up a random num between 1-5
                    arr[row][col] = rando; //set to rando
                    bools[row][col]=true;
                }
            }
        }
    }
    
    public static boolean isPrime(int num){
        switch(num){
            case 1:
                return false;
            case 2:
            case 3:
            case 5:
            case 7:
                return true;
        }
        for(int divider = 2; divider<=7;divider++){
            if(num%divider==0){
                return false;
            }
        }
        return true;
    }
    
    public static void level5(int[][] arr, boolean[][]bools){
        for(int row = 0; row<=9; row++){ //iterate through each row
            for(int col = 0; col<=9; col++){ //iterate through each col
                if(isPrime(arr[row][col]) && bools[row][col] == false){ //TODO: make a boolean that checks if an int is prime
                    arr[row][col] = arr[row][col]/2+1;
                    bools[row][col]=true;
                }
            }
        }
        System.out.println("Level 5");
    }
    
    public static int level7(int[][] arr, int random, boolean[][]bools){
        switch(random){
            case 1:
                level1(arr, bools);
                return 1;
            case 2:
                level2(arr, bools);
                return 2;
            case 3:
                level3(arr, bools);
                return 3;
            case 4:
                level4(arr, bools);
                return 4;
            case 5:
                level5(arr, bools);
                return 5;
        }
        return 0;
    }
    
    public static void level8(int[][] arr, boolean[][]bools){
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        while(true){
            int random = (int)(Math.random()*5 + 1);
            int x = level7(arr,random, bools);
            if(random==1){
                one = true;
            }
            else if(random==2){
                two = true;
            }
            else if(random==3){
                three = true;
            }
            else if(random==4){
                four = true;
            }
            else if(random==5){
                five = true;
            }
            if(one && two && three && four && five){
                break;
            }
        }
    }
    
    public static void level9(int[][] arr, boolean[][]bools){
        boolean one = false;
        int oneCount = 0;
        boolean two = false;
        int twoCount = 0;
        boolean three = false;
        int threeCount = 0;
        boolean four = false;
        int fourCount = 0;
        boolean five = false;
        int fiveCount = 0;
        
        while(true){
            int random = (int)(Math.random()*5 + 1);
            if(random==1 && oneCount<2){
                one = true;
                level7(arr,random,bools);
                oneCount++;
            }
            else if(random==2 && twoCount<2){
                two = true;
                level7(arr,random,bools);
                twoCount++;
            }
            else if(random==3 && threeCount<2){
                three = true;
                level7(arr,random,bools);
                threeCount++;
            }
            else if(random==4 && fourCount<2){
                four = true;
                level7(arr,random,bools);
                fourCount++;
            }
            else if(random==5 && fiveCount<2){
                five = true;
                level7(arr,random,bools);
                fiveCount++;
            }
            if(one && two && three && four && five){
                break;
            }
        }
    }
    
    public static void level11(Scanner user, int[][]arr, boolean[][]bools){
        int x;
        System.out.print("What Level (except 6) throuh 1-9");
        while (true){
            try{
                x = user.nextInt();
                if (x==6){
                    System.out.println("Try Again");
                }
                else if(1<=x && x<=9){
                    user.nextLine();
                    break;
                }
                else{
                    System.out.println("Try Again");
                }
            }
            catch(Exception e){
                System.out.println("Try Again");
                user.nextLine();
            }
        }
        
        switch(x){
            case 1:
                level1(arr,bools);
                break;
            case 2:
                level2(arr,bools);
                break;
            case 3:
                level3(arr,bools);
                break;
            case 4:
                level4(arr,bools);
                break;
            case 5:
                level5(arr,bools);
                break;
            case 7:
                int random = (int)(Math.random()*5 + 1);
                level7(arr,random,bools);
                break;
            case 8:
                level8(arr,bools);
                break;
            case 9:
                level9(arr,bools);
                break;
        }
    }

    
    public static void main(String[]args){
        Scanner user = new Scanner(System.in);
        
        
        int[][]arr = setGrid();
        boolean[][]bools = new boolean[10][10];
        
        level11(user, arr, bools);
        printGrid(arr);
        for(int i = 0; i<= 40; i++){
            System.out.print("-");
        }
        System.out.println("");
        
        level11(user, arr, bools);
        printGrid(arr);
        for(int i = 0; i<= 40; i++){
            System.out.print("-");
        }
        System.out.println("");
        
        printBoolGrid(bools);
    }
}

