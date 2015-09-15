package agile.labs.unit;

public class Counter {
    int value;
    int limit;

    public Counter(int limit) {
        this.limit = limit;
        value = 0 ;
    }

    public int getValue() {
        return value;
    }

    public int increment() {
        if ( ++value > limit) {  
            value = 0;
        }
        return value ;
    }
    
    public int step(int amount){
    
    	value = value+=amount;
    	
    	if ((value) > limit){
    		value = value-limit;
    	
    	}
    	
    	return value;
    }
}