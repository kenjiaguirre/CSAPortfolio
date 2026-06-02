public class CombinedTable{
    
    private SingleTable t1;
    private SingleTable t2;
    
    public CombinedTable(SingleTable one, SingleTable two){
        t1 = one;
        t2 = two;
    }
    
    public boolean canSeat(int num){
        int seats = t1.getNumSeats() + t2.getNumSeats() - 2;
        if(seats>=num){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double getDesirability(){
        double desire = (t1.getViewQuality() + t2.getViewQuality())/2;
        if(t1.getHeight()==t2.getHeight()){
            return desire;
        }
        else{
            return desire -10;
        }
    }
}
