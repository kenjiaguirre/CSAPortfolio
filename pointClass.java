public class Point{
    double x;
    double y;
    double z;
    String n;
    boolean isPolar;
    String cart ="Cartesian";
    String pol = "Polar";
    
    //constructs a point with no parameters called "unnamed" at origin
    public Point(){
        x=0;
        y=0;
        isPolar=false;
        n="Unnamed Cartesian Point";
    }
    
    //constructs a polar/cartesian point at (x,y) called "n"
    public Point (double initialX, double initialY, boolean type, String name){
        x = initialX;
        y = initialY;
        isPolar = type;
        if (!isPolar){
            n = "Cartesian Point " + name;
        }
        else{
            n = "Polar Point " + name;
        }
    }
    
    
    //constructs a polar/cartesian point at (x,y,z) called "n" (3D POLAR POINTS ARE EXPERIMENTAL; don't know how to integrate... YET)
    public Point (double initialX, double initialY, double initialZ, boolean type, String name){
        x = initialX;
        y = initialY;
        z = initialZ;
        isPolar = type;
        if (!isPolar){
            n = "Cartesian Point " + name;
        }
        else{
            n = "Polar Point " + name;
        }
    }
    
    //converts a point to its coordinates (ex: p1 -> (x,y))
    public String toString(){
        if(z!=0){
            return "("+x+","+y+","+z+")";
        }
        else{
            return "("+x+","+y+")";
        }
    }
    
    //moves a coordinate point dx,dy
    public void translate(double dx, double dy){
        if(!isPolar){
            x+=dx;
            y+=dy;
        }
        else{
            toCartesian();
            x+=dx;
            y+=dy;
            toPolar();
        }
    }
    
    //moves a coordinate point dx,dy,dz
    public void translate(double dx, double dy, double dz){
        if(!isPolar){
            x+=dx;
            y+=dy;
            z+=dz;
        }
        else{
            toCartesian();
            x+=dx;
            y+=dy;
            z+=dz;
            toPolar();
        }
    }
    
    //gets the distance of a point from the origin using pythagorean theorem
    public double getDistance(){
        if(!isPolar){
            double c=Math.sqrt(x*x+y*y+z*z);
            return c;
        }
        else{
            return x;
        }
    }
    
    //compaares the disance of two points and returns which one is greater
    public void compareDistance(Point a, Point b){
        double one;
        double two;
        if(!a.isPolar){
            one = a.getDistance();
        }
        else{
            one = a.x;
        }
        if(!b.isPolar){
            two = b.getDistance();
        }
        else{
            two = b.x;
        }
        
        if(one>two){
            System.out.println(a.n + " is greater than " + b.n);
        }
        else if (one<two){
            System.out.println(b.n + " is greater than " + a.n);
        }
        else{
            System.out.println(a.n +" and " + b.n + " have the same distance.");
        }
    }
    
    public double getAngle(){
        double a=x; //placeholder for x
        double b=y; //placeholder for y
        if(!isPolar){
            if(a>0 && b>0){ //1st quadrant
                return Math.atan(b/a);
            }
            else if(a<0 && b>0 || a<0 && b<0){ //2nd & 3rd quadrant
                return Math.atan(b/a) + Math.PI;
            }
            else if(a>0 && y<0){ //4th quadrant
                return Math.atan(b/a) + 2*Math.PI;
            }
            else if(a>0 && b==0 || a==0 && b==0){ //x is on positive x axis;
                return 0;
            }
            else if(a==0 && b>0){//y is on positive y axis;
                return Math.PI/2;
            }
            else if(a<0 && b==0){//x is on negative x axis;
                return Math.PI;
            }
            else if(a==0 && b<0){//y is on negative y axis;
                return 3*Math.PI/2;
            }
            return 0;
        }
        else{
            return y;
        }
        
    }
    
    public void toPolar(){
        double a=getDistance();
        double b=getAngle();
        int location = n.indexOf(cart);
        if (!isPolar){
            isPolar=true;
            //code for concatenation from AP Classroom videos! yay!!!
            n = n.substring(0,location) + pol + n.substring(location+cart.length());
            x=a;
            y=b;
        }
        else{
            
        }
    }
    
    public void toCartesian(){
        double a=x;
        double b=y;
        int location = n.indexOf(pol); //code from AP Classroom videos! yay!!!!!
        if(isPolar){
            isPolar=false;
            n = n.substring(0,location) + cart + n.substring(location+pol.length());
            y = Math.round(a*Math.sin(b)); //round because numbers are always decimals away
            x = Math.round(a*Math.cos(b)); //round because numbers are always decimals away
        }
        else{
            
        }
    }
    
    public void rotate(double radians){
        double a=x;
        double b=y;
        if(!isPolar){ //points that are originally cartesian stay cartesian 
            toPolar();
            y+=radians;
            toCartesian();
        }
        else{
            y+=radians;
        }
    }
}
