import java.util.Scanner;

public class Azienda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Dipendente[] dipendenti = new Dipendente[2];
        int count = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi dipendente");
            System.out.println("2. Visualizza dipendenti");
            System.out.println("3. Esci");
            
            int scelta;
            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!");
                continue;
            }
            
            switch (scelta) {
                case 1:
                	
                	// Array iniziale con capacità 2 (può essere anche 1 o un altro valore)
                    // Essendo gli array un dato statico, non possono essere modificati dopo la creazione
                    // Possiamo però ricopiare i dipendenti che creeremo in un nuovo array più capiente quando è pieno
                	
                    if (count == dipendenti.length) {
                        Dipendente[] nuovoArray = new Dipendente[dipendenti.length * 2];
                        System.arraycopy(dipendenti, 0, nuovoArray, 0, dipendenti.length);
                        dipendenti = nuovoArray;
                    }
                    
                    dipendenti[count] = aggiungiDipendente(scanner);
                    count++;
                    System.out.println("Dipendente aggiunto con successo!");
                    break;
                    
                case 2:
                    visualizzaDipendenti(count, dipendenti);
                    break;
                    
                case 3:
                    System.out.println("Alla prossima!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }
    
    public static Dipendente aggiungiDipendente(Scanner scanner) {
        System.out.println("Inserisci il nome del dipendente:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome del dipendente:");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci l'email del dipendente:");
        String email = scanner.nextLine();
        return new Dipendente(nome, cognome, email);
    }
    
    public static void visualizzaDipendenti(int count, Dipendente[] dipendenti) {
    	
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
}
