import java.util.Scanner;

public class ArrayOggetti {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di persone che vuoi inserire:");
        
        int n = Integer.parseInt(scanner.nextLine());
        Persona persone[] = new Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Inserisci il nome della persona " + (i + 1) + ":");
            String nome = scanner.nextLine();
           
            System.out.println("Inserisci il cognome della persona " + (i + 1) + ":");
            String cognome = scanner.nextLine();
            
            System.out.println("Inserisci l'età della persona " + (i + 1) + ":");
            int eta;
            
            while (true) {
                try {
                    eta = Integer.parseInt(scanner.nextLine()); // Legge l'intera riga ed evita problemi di buffer
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Errore: inserisci un numero valido per l'età.");
                }
            }

            persone[i] = new Persona(nome, cognome, eta);
        }

        System.out.println("Le persone inserite sono:");
        for (int i = 0; i < n; i++) {
        	System.out.println("Persona " + (i + 1) + ": " + persone[i].getNome() + " " + persone[i].getCognome() + " " + persone[i].getEta());
        }

        scanner.close(); // Chiude lo scanner per evitare memory leaks
    }
}
