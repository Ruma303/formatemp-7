import java.util.Scanner;

public class OperazioniCRUD {

	private static Dipendente[] dipendenti = new Dipendente[1];
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {

			mostraMenu();
			String scelta = scanner.nextLine();

			switch (scelta) {
			case "1":
				aggiungiDipendente(scanner);
				break;
			case "2":
				visualizzaDipendenti();
				break;
			case "3":
				aggiornaDipendente(scanner);
				break;
			case "4":
				eliminaDipendente(scanner);
				break;
			case "5":
				System.out.println("Alla prossima!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Scelta non valida!");
				break;
			}
		}
	}

	// Funzione per mostrare il menu
	private static void mostraMenu() {
		System.out.println("\nMenu:");
		System.out.println("1. Aggiungi dipendente");
		System.out.println("2. Visualizza dipendenti");
		System.out.println("3. Aggiorna dipendente");
		System.out.println("4. Elimina dipendente");
		System.out.println("5. Esci");
	}
	
	// Funzione per aggiungere un dipendente
    private static void aggiungiDipendente(Scanner scanner) {
        
    	if (count == dipendenti.length) {
    		
	    	// Array iniziale con capacità 2 (può essere anche 1 o un altro valore)
	    	// essendo gli array un dato statico, non possono essere modificati dopo la creazione.
	    	// Possiamo però ricopiare i dipendenti che creeremo in un nuovo array più capiente quando è pieno.
    	
            Dipendente[] nuovoArray = new Dipendente[dipendenti.length * 2];
            
	         // Questa istruzione copia tutti gli elementi dal vecchio array dipendenti a partire dall'indice 0,
	         // fino alla lunghezza totale, dentro il nuovo array nuovoArray, a partire anch'esso dall'indice 0.
	         // In questo modo, tutti i dipendenti già inseriti vengono preservati.
            
            System.arraycopy(dipendenti, 0, nuovoArray, 0, dipendenti.length);
	
	         // Il vecchio array dipendenti viene punta al nuovo array nuovoArray. 
             // Questo significa che, da questo momento in poi, tutte le operazioni (come aggiungere nuovi
	         // dipendenti) verranno effettuate su questo array ampliato.
            
            dipendenti = nuovoArray;
        }
        dipendenti[count] = creaDipendente(scanner);
        count++;
        System.out.println("Dipendente aggiunto con successo!");
    }

	private static Dipendente creaDipendente(Scanner scanner) {
		System.out.println("Inserisci il nome del dipendente:");
		String nome = scanner.nextLine();
		System.out.println("Inserisci il cognome del dipendente:");
		String cognome = scanner.nextLine();
		System.out.println("Inserisci l'email del dipendente:");
		String email = scanner.nextLine();
		return new Dipendente(nome, cognome, email);
	}

	private static void visualizzaDipendenti() {
		if (count == 0) {
			System.out.println("\nNessun dipendente inserito!");
			return;
		}
		System.out.println("I dipendenti inseriti sono:");
		for (int i = 0; i < count; i++) {
			System.out.println("\tDipendente " + (i + 1) + ": " 
					+ dipendenti[i].getNome() + " "
					+ dipendenti[i].getCognome() + " | " 
					+ dipendenti[i].getEmail());
		}
	}

	private static void aggiornaDipendente(Scanner scanner) {
		if (count == 0) {
			System.out.println("\nNessun dipendente da aggiornare!");
			return;
		}
		System.out.println("Inserisci l'indice del dipendente da aggiornare:");
		int indice;
		try {
			indice = Integer.parseInt(scanner.nextLine()) - 1;
		} catch (NumberFormatException e) {
			System.out.println("Inserisci un numero valido!");
			return;
		}
		if (indice < 0 || indice >= count) {
			System.out.println("Indice non valido!");
			return;
		}
		dipendenti[indice] = creaDipendente(scanner);
		System.out.println("Dipendente aggiornato con successo!");
	}

	private static void eliminaDipendente(Scanner scanner) {
		if (count == 0) {
			System.out.println("\nNessun dipendente da eliminare!");
			return;
		}
		System.out.println("Inserisci l'indice del dipendente da eliminare:");
		int indice;
		try {
			indice = Integer.parseInt(scanner.nextLine()) - 1;
		} catch (NumberFormatException e) {
			System.out.println("Inserisci un numero valido!");
			return;
		}
		if (indice < 0 || indice >= count) {
			System.out.println("Indice non valido!");
			return;
		}
		// Spostiamo tutti gli elementi dopo l'indice verso sinistra
		for (int i = indice; i < count - 1; i++) {
			dipendenti[i] = dipendenti[i + 1];
		}
		dipendenti[count - 1] = null; // Aiuta il garbage collector
		count--;
		System.out.println("Dipendente eliminato con successo!");
	}
}