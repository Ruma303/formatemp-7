public class TestaCroce {
	// Costanti che indicano le 2 opzioni
	private final static String TESTA = "testa";
	private final static String CROCE = "croce";
	
	// ----------------------------------------------------------------------------------------------------	
	// Getters

	public static String getTesta() {
		return TESTA;
	}
	public static String getCroce() {
		return CROCE;
	}
	
	// ----------------------------------------------------------------------------------------------------	
	// Metodo che controlla la mossa dell'utente e quella random e definisce il vincitore
	
	public static String getWinner(String userMove, String randomMove) {
		System.out.println(String.format("Hai scelto %s ed è uscito %s", userMove, randomMove));
		
		boolean userWinner = userMove.equals(randomMove);
		
		return userWinner ? "Hai vinto ;)" : "Hai perso :(";
	}
}