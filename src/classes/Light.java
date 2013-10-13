package classes;

public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen gr�n n�r time<green 

    public Light(int period, int green) {
        time = 0;
        this.period = period;
        this.green = green;
    }

    public void step() { 
       if(time == (period - 1))
           time = 0;
       else
         time++;
    }

    public boolean isGreen() {
        if(time >= green && time < period) {
            return false;
        } else {
            return true;
        }
    }   
    

    @Override
    public String toString()  {
        return "Light(" + this.isGreen() + ")";
    }
	
}