package classes;

import java.util.Calendar;

public class Car {

    static int staticBornTime = 0;
    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng
    
    private Calendar rightNow = Calendar.getInstance();
    
    

    public Car(){
        this.dest = (int)(Math.random() * 2) + 1;
        Car.staticBornTime++; //((rightNow.get(Calendar.SECOND) * 1000) + rightNow.get(Calendar.MILLISECOND));
        bornTime = Car.staticBornTime;
    }
    
    public Car(int _dest){
        this.dest = _dest;
        Car.staticBornTime++; //((rightNow.get(Calendar.SECOND) * 1000) + rightNow.get(Calendar.MILLISECOND));
        bornTime = Car.staticBornTime;
    }
    
    public int getBornTime(){
        return bornTime;
    }
    
    public int getDest(){
        return dest;
    }
    
    @Override
    public String toString() {
        return "Car(" + this.bornTime + ", " + this.dest + ")";
    }
	
}