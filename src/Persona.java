public class Persona {
    private String nome;
    private String cognome;
    private String email;
    private int eta;

    public Persona(String nome, String cognome, String email, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    
    public String getEmail() {
        return email;
    }

    public int getEta() {
        return eta;
    }
}
