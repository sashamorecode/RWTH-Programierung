import java.util.Arrays;

public class ImprovedSelectionSort {

    public static void sort(int[] a) {
    	
	    	int minIndex;
	    	int maxIndex;
	    	
	    	
	    	for(int n = 1; n<a.length /2 +1; n++) {
	    		
	    		maxIndex = a.length - n;
	    		minIndex = n-1;
	    		
	    		//suche min und max
	    		for(int m = n-1; m <= a.length - n; m++) {
	    			
	    			if(a[m] < a[minIndex]) {
	    				minIndex = m;
	    			}
	    			
	    			if(a[m] > a[maxIndex]) {
	    				maxIndex = m;
	    			}
	    			
	    		}
	    		//Vertauche min und max mit a[n-1] und a[len(a) -n]
	    		int minTemp = a[minIndex];
	    		int maxTemp = a[maxIndex];
	    		
	    		a[minIndex] = a[n-1];
	    		a[maxIndex] = a[a.length -n];
	    		
	    		a[n-1] = minTemp;
	    		a[a.length - n] = maxTemp;
	    		
	   
	    		
	    	}
   
    
    	
 
    }
    
    
}
