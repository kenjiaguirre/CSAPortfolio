import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
        
        Scanner pattern = new Scanner(System.in);
        Integer number3 = null;
        
        while(number3 == null){ //User Input Program: gets a number and repeats if invalid
            System.out.print("Enter a number: ");
            try{
                number3 = pattern.nextInt(); //max - tells when anchor to stop going up
                if(number3 != null){
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid value." + "\n");
                pattern.nextLine();
            }
        }
        
        int rows = number3;
        for (int i = 1; i <= rows; i++) {
            for (int s  = 1;s <= rows - i; s++) {
                
                System.out.printf("%3s", "");
            }
            for (int j  = i;j >= 1; j--) {
                
                System.out.printf("%3s", j);
            }
            for (int j  = 2;j <= i; j++) {
                
                System.out.printf("%3s", j);
            }
            System.out.println();
        }
        
    }
}
