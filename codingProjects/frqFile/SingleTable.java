public class SingleTable{
    private int numSeats;
    private int height;
    private double viewQuality;
    
    public SingleTable(int seat, double view, int h){
        numSeats = seat;
        height = h;
        viewQuality = view;
    }
    
    public int getNumSeats(){
        return numSeats;
    }
    
    public int getHeight(){
        return height;
    }
    
    public double getViewQuality(){
        return viewQuality;
    }
    
    public void setViewQuality(double value){
        viewQuality = value;
    }
    
}
