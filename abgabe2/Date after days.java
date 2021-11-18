
public class main {
	
	
	public static int getDays(int month) {
		switch(month) {
			case 1: case 3: case 5:
	        case 7: case 8: case 10:
	        case 12:
	            return 31;
		case 4: case 6:
	        case 9: case 11:
	            return 30;
			
			case 2:
				return 28;
		}
		return 99999;

	}
	
	
	public static void main (String[] args) {
		
		int day = SimpleIO.getInt("Bitte geben Sie die Tageskomponente des Startdatums ein.");
		int month = SimpleIO.getInt("Bitte geben Sie die Monatskomponente des Startdatums ein.");
		int year = SimpleIO.getInt("Bitte geben Sie die Jahreskomponente des Startdatums ein.");
		int t = SimpleIO.getInt("Bitte geben Sie die Anzahl an Tagen ein:");
		int numDays;
		int ogT = t;
		
		while(t > 0) {
			
			
			numDays = getDays(month);
			
			while(day <= numDays){
				if(t>0) {
					day++;
					t--;
				}
				
				if(t == 0) {
					SimpleIO.output("Das Datum " + day +"." + month + "." + year + " befindet sich " + ogT + " Tag nach dem Startdatum.");
					System.exit(0);
				}
				
			}
			day = 1;
			if(t > 0) {
				month++;
			}
			if(month == 13) {
				month = 1;
				year++;
			}
			
		}
		SimpleIO.output("Das Datum " + day +"." + month + "." + year + " befindet sich " + ogT + " Tag nach dem Startdatum.");
	}
	
	
}
