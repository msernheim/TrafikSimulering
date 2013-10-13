package classes;

public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas n�r det inte gick att l�gga 
        // in en ny bil p� v�gen
        public OverflowException(String message){
            super(message);
        }
    }

    private Car[] theLane;

    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats f�r n fo
        theLane = new Car[n];
        for (int i = 0; i < n; i++) {
            theLane[i] = null;
        }
    }

    public void step() {
	// Stega fram alla fordon (utom det p� plats 0) ett steg 
        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
	// mm h a metoden nedan.)
        for (int i = 0; i < theLane.length - 1; i++) {
            if(theLane[i] == null) {
              
                theLane[i] = theLane[i+1];
                theLane[i+1] = null;
            }
        }
    }

    public Car getFirst() {
	Car tempCar = firstCar();
        theLane[0] = null;
        return tempCar; // Returnera och tag bort bilen som st�r f�rst
    }

    public Car firstCar() {
        return theLane[0];
    }


    public boolean lastFree() {
        if(theLane[theLane.length - 1] != null)
        {
            return false;
        }
        else
            return true;
    }

    public void putLast(Car c) throws OverflowException {
	// St�ll en bil p� sista platsen p� v�gen
	// (om det g�r).
        if(theLane[theLane.length - 1] == null){
            theLane[theLane.length - 1] = c;
        } else {
            throw new OverflowException("Can't add a new car last");
            
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < (theLane.length - 1); i++) {
            if(theLane[i] != null)
                s += " | " + (theLane[i].toString()) + "    ";
            else
                s += " | \t\t   ";
        }
        System.out.println();
        return s;
    }

}
