import java.util.Arrays;

public class MyClass {
    public static void main(String args[]) {
      
        int[]random={18,21,40,53,60,23,4,18,24,51,56,41,15,28,57,58,63,23,5,19,21,28,64,14,5,27,45,56,59,4,6,24,39,43,51,2,5,8,27,49,57,14,5,28,34,37,55,17};
        int i;
        int temp;
        int k;
        
        //Section #4
        for(k=0;k<random.length;k++){ //index k starts at 0 then goes up by 1 after every runthrough of the list
            for(i=k;i<random.length;i++){ //goes through each index (i) and compares them to index k; counts as one runthrough of the list
                if(random[k]>random[i]){ //if the number on index k is greater than index i, then swap them
                    temp = random[k];//swapping mechanism(uses temporary variable)
                    random[k]=random[i];
                    random[i]=temp;
                }
                
            }
        }
        for(int num:random){
            System.out.print(num+" ");
        }
        System.out.println();
        
        //Section #5
        random=new int[]{18,21,40,53,60,23,4,18,24,51,56,41,15,28,57,58,63,23,5,19,21,28,64,14,5,27,45,56,59,4,6,24,39,43,51,2,5,8,27,49,57,14,5,28,34,37,55,17};
        boolean unorder=true;
        while(unorder){//algorithm continues until the list is ordered
            unorder=false;//reset unordered boolean after every runthrough the list
            for(i=0;i<(random.length-1);i++){ //goes through each index and compares them with the next one; there is no further index past random.length(last position), so have to subtract one
                if(random[i]<random[(i+1)]){//if the number on index i is greater than index i+1(the next one), then swap them
                    unorder=true;//means the list is unordered; will have to continue again
                    temp=random[i];//swapping mechanism(uses temporary variable)
                    random[i]=random[(i+1)];
                    random[(i+1)]=temp;
                }
                //if the if statement isn't ran, then that means that list is ordered and the algorithm will stop
            }
        }
        for(int num:random){
            System.out.print(num+" ");
        }
        System.out.println();
        
        //Section #6
        //code is the same; the only difference is that if index k is less than index i, then it gets swap; ensures that bigger numbers are on the left
        random=new int[]{18,21,40,53,60,23,4,18,24,51,56,41,15,28,57,58,63,23,5,19,21,28,64,14,5,27,45,56,59,4,6,24,39,43,51,2,5,8,27,49,57,14,5,28,34,37,55,17};
        for(k=0;k<random.length;k++){
            for(i=k;i<random.length;i++){
                if(random[k]<random[i]){
                    temp = random[k];
                    random[k]=random[i];
                    random[i]=temp;
                }
                
            }
        }
        for(int num:random){
            System.out.print(num+" ");
        }
        System.out.println();
        
        //Section #7
        //code is the same; the only difference is that if index i is greater than index i+1, then it gets swap; ensures that smaller numbers are on the left
        random=new int[]{18,21,40,53,60,23,4,18,24,51,56,41,15,28,57,58,63,23,5,19,21,28,64,14,5,27,45,56,59,4,6,24,39,43,51,2,5,8,27,49,57,14,5,28,34,37,55,17};
        unorder=true;
        while(unorder){
            unorder=false;
            for(i=0;i<(random.length-1);i++){
                if(random[i]>random[(i+1)]){
                    unorder=true;
                    temp=random[i];
                    random[i]=random[(i+1)];
                    random[(i+1)]=temp;
                }
            }
        }
        for(int num:random){
            System.out.print(num+" ");
        }
        System.out.println();
    
    
    }
  
  
}





