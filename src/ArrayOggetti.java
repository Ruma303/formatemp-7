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
            
            System.out.println("Inserisci l'email della persona " + (i + 1) + ":");
            String email = scanner.nextLine();           
            
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

            persone[i] = new Persona(nome, cognome, email, eta);
        }
        
        getInfo(n, persone); // Invoca il metodo per stampare le info delle persone

        scanner.close(); // Chiude lo scanner per evitare memory leaks
    }
    
    public static void getInfo(int n, Persona[] persone) {
        System.out.println("Le persone inserite sono:");
        for (int i = 0; i < n; i++) {
        	System.out.println("Persona " + (i + 1) + ": " + persone[i].getNome() + " " + persone[i].getCognome() + " " + persone[i].getEta());
        }
    }
}
