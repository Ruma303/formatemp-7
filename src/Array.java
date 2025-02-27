
public class Array {

	public static void main(String[] args) {
		
		
		// Array di interi
		int[] etaStudenti = new int[]{9, 29, 11, 12, 43, 14, 18};
		
		int etaMedia = 0;
		int maggiorenni = 0;
		int minorenni = 0;
		
		int i = 0;
			
		do {
			System.out.println("Età studente " + (i+1) + ": " + etaStudenti[i]);
			
            if (etaStudenti[i] >= 18)
            	maggiorenni++;
            else
            	minorenni++;
            
            etaMedia += etaStudenti[i];
            i++;
			
		} while (i < etaStudenti.length);
		
		etaMedia /= etaStudenti.length;
		
		System.out.println("Età media studenti: " + etaMedia);
		System.out.println("Numero maggiorenni: " + maggiorenni);
		System.out.println("Numero minorenni: " + minorenni);

	}

}
