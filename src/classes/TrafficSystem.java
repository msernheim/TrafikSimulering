package classes;

public class TrafficSystem {
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    
    private int randomizer = 8;

    public TrafficSystem() {
        r0 = new Lane(10);
        r1 = new Lane(10);
        r2 = new Lane(10);
        s1 = new Light(10, 5);
        s2 = new Light(10, 5);
    }

    public void readParameters() {
	// L�ser in parametrar f�r simuleringen
	// Metoden kan l�sa fr�n terminalf�nster, dialogrutor
	// eller fr�n en parameterfil. Det sista alternativet
	// �r att f�redra vid uttestning av programmet eftersom
	// man inte d� beh�ver mata in v�rdena vid varje k�rning.
        // Standardklassen Properties �r anv�ndbar f�r detta. 
    }

    public void step() {
        //Random the interval between the cars
        if(((Math.random() * 10) + 1) < randomizer) r0.putLast(new Car());      
        
        //Remove car at light s1 if green signal
        if(s1.isGreen()) r1.getFirst();                                         
        
        // Remove car at light s2 if green signal
        if(s2.isGreen()) r2.getFirst();                                         
        
        // Check is possible to move from r0 to r1/r2. If possible, do it
        if(r0.firstCar() != null) {
            if(r0.firstCar().getDest() == 1 && r1.lastFree()){
                r1.putLast(r0.getFirst());
            } else if(r0.firstCar().getDest() == 2 && r2.lastFree()) {
                r2.putLast(r0.getFirst());
            } else {
                return;
            }
        }
        
        // Lane stepping
        r1.step();
        r2.step();
        r0.step();
        s1.step();
        s2.step();
    }

    public void printStatistics() {
	// TODO
    }

    public void print() {
	// TODO
    }
    
    @Override
    public String toString(){
        String s = "";
        return "r0(" + r0.toString() + ")\n" + 
               "s1(" + s1.toString() + ")\n" +
               "r1(" + r1.toString() + ")\n" + 
               "s2(" + s2.toString() + ")\n" + 
               "r2(" + r2.toString() + ")\n";
    }

}
