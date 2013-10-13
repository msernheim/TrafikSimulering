package classes;

//import java.util.Calendar;

public class Simulation {
    
    static final int simulationTime = 30;
    
    static TrafficSystem ts;
    //static Calendar rightNow;

    public static void main(String[] args){
        
        ts = new TrafficSystem();
        //rightNow = Calendar.getInstance();

        int counter = 0;
        while(counter <= simulationTime){
            ts.step();
            System.out.println(ts.toString());
            counter++;
        }
    }  
}