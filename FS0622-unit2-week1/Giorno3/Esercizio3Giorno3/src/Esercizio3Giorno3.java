import java.util.Scanner;

/*
 * Esercizio#3: while
 * SCrivere un programma che chiede di inserire una stringa e la suddivida in caratteri separati dalla virgola.
 * Il programma si ripete fino a che l'utente non inserisca la stringa ":q".
 */
public class Esercizio3Giorno3 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stringa = null;
		do {
			System.out.println("Inserire una stringa seguita dal tasto Invio");
			stringa = scanner.nextLine();

			// Splitta la riga in un array di caratteri
			String[] arrayStringa = stringa.split(""); // il metodo split() ci consente di prendere tutti i caratteri
														// singoli di una stringa e metterli in un array di stringhe,
														// può essere gestita con un parametro

			String stringaSpezzata = null;

			for (int i = 0; i < arrayStringa.length; i++) {
				if (stringaSpezzata == null) {
					stringaSpezzata = arrayStringa[i];
				} else {
					stringaSpezzata = stringaSpezzata + "," + arrayStringa[i];
				}
			}

			System.out.println("Stringa spezzata: " + stringaSpezzata);
			// Ripete fino a che la stringa non è diversa da ":q"
		} while (!":q".equals(stringa));

		scanner.close();

	}

}
