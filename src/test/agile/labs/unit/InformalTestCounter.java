package agile.labs.unit;

public class InformalTestCounter {
	public static void main(String[] args) {
	    int limit = 10 ;
	    Counter counter = new Counter(limit) ;
	    counter.increment();
	    int result = counter.increment();
	    if (result != 2) {
	        System.out.println("Simple case failed");
	    }
	    for (int i = 2; i < limit ; i++) {
	        counter.increment();
	    }
	    result = counter.increment();
	
	    if (result != 0) {
	        System.out.println("Boundry case failed");
	    }
	    
	    counter.value = 0;
	    
	    for (int i = 2; i <10 ; i++) {
	        counter.step(3);
	        System.out.println(counter.value);
	    }
	    
	    	result = counter.step(3);
	    if (result!=7){
	    	
	    	System.out.println("Step case failed");
	    }
	    
	    
	}
}
