public class SelectionSort {

    public static void sort(int[] a) {


    	int minIndex;

    	for(int n = 0; n<a.length; n++) {
    		

    		minIndex = n;
    		for(int m = 1+n; m < a.length; m++) {
    			//checke ob mindests wert
    			if(a[m] < a[minIndex]) {
    				minIndex = m;
    			}
    			
    		}
    		
    		// vertauche min wert min a[minIndex]
    		int minTemp = a[minIndex];
    		
    		a[minIndex] = a[n];
    		a[n] = minTemp;

    		
    		

    		
    	}
    
    	
    	
    }
   
}
