public class Main{
    
    public static void main(String args[]) {
        
        //six new Point objects
        Point p1 = new Point(-5,-2, false,"Alpha");
        Point p2 = new Point(4,3,false,"Bravo");
        
        Point p3 = new Point();
        p3.x=10;
        p3.y=7;
        p3.isPolar=false;
        p3.n="Cartesian Point Charlie";
        
        Point p4 = new Point();
        Point p5 = new Point (2,3,-4,false,"DACKY DUCKY WHOA WHOA WHAT!?!?");
        Point p6 = new Point (10,Math.PI/2,true,"Echo");
        
        //print each point
        System.out.println("where each point is.");
        System.out.println(p1.n + ": " + p1.toString());
        System.out.println(p2.n + ": " + p2.toString());
        System.out.println(p3.n + ": " + p3.toString());
        System.out.println(p4.n + ": " + p4.toString());
        System.out.println(p5.n + ": " + p5.toString());
        System.out.println(p6.n + ": " + p6+"\n");
        
        //move points and then print it again
        System.out.println("Translations");
        p2.translate(2,4);
        System.out.println(p2.n + " is translated to " + p2.toString());
        p2.translate(-3,5);
        System.out.println(p2.n + " is translated to " + p2.toString());
        p5.translate(20,2,5);
        System.out.println(p5.n + " is translated to " + p5.toString());
        p5.translate(-12,2);
        System.out.println(p5.n + " is translated to " + p5.toString());
        p6.translate(-5,-5);
        System.out.println(p6.n + " is translated to " + p6 + "\n");
        
        //get distance
        System.out.println("Distances of points");
        System.out.println(p1.n + " is " + p1.getDistance() + " units from the origin");
        System.out.println(p2.n + " is " + p2.getDistance() + " units from the origin");
        System.out.println(p6.n + " is " + p6.getDistance() + " units from the origin");
        System.out.println(p5.n + " is " + p5.getDistance() + " units from the origin\n");
        
        //compare distance
        System.out.println("Comparison of points' distances");
        p1.compareDistance(p1, p2);
        p1.compareDistance(p3, p4);
        p1.compareDistance(p1, p5);
        System.out.println("");
        
        //Cartesian & Polar tests
        System.out.println("Testing out cartesian/polar conversions");
        p1.translate(-5,-8);
        System.out.println(p1.n + p1);
        p1.toPolar();
        System.out.println(p1.n + p1);
        p1.toCartesian();
        System.out.println(p1.n + p1);
        
        p4.translate(-5,0);
        System.out.println(p4.n + p4);
        p4.toPolar();
        System.out.println(p4.n + p4);
        p4.toCartesian();
        System.out.println(p4.n + p4 + "\n");
        
        System.out.println("Rotations");
        System.out.print(p4.n + " is rotated 135 deg clockwise from " + p4);
        p4.rotate(-3*Math.PI/4);
        System.out.println(" to " + p4);
        
        System.out.print(p5.n+p5 + ": was rotated 90 deg counter clockwise to");
        p5.rotate(Math.PI/2);
        System.out.println(p5);
        
        System.out.print(p2.n + " is rotated 150 deg counter clockwise from " + p2);
        p2.rotate(5*Math.PI/6);
        System.out.print(" to " + p2 + ", then rotated 150 deg counter clockwise to ");
        p2.rotate(5*Math.PI/6);
        System.out.println(p2);
        
        System.out.print(p6.n + " is rotated 330 deg clockwise from " + p6);
        p6.rotate(-11*Math.PI/6);
        System.out.println(" to " + p6);
    }
}
