/*Esercizio#1: if-else-if
	 * Scrivere le seguenti funzioni:
	 * -stringaPariDispari, che accetta una stringa e ritorna sempre true se il numero dei caratteri è pari 
	 *  e false se il numero di caratteri è dispari;
	 * -annoBisestile, che accetta un anno espresso come intero e ritorna true se esso è bisestile, false altrimenti.
	 * Un anno per essere Bisestile deve rispettare entrsmbe le seguenti regole:
	 * -essere divisibile per 4;
	 * -qualora sia divisibile per 100 deve essere anche divisibile per 400.
	 * 
	 * Scrivere un main che utilizzi le funzioni. 
	 */

import java.util.Scanner;

public class Esercizio1 {

	// Inizializza lo scanner per l'acquisizione dell'input utente
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		verificaStringaPariDispari();
		verificaAnnoBisestile();

		scanner.close();

	}

	public static void verificaStringaPariDispari() {
		System.out.println("Verifica se il numero di caratteri della stringa è pari o dispari");
		System.out.println("Inserire la stringa da verificare seguita dal tasto Invio");
		String stringa = scanner.nextLine();

		boolean pari = stringaPariDispari(stringa);

		if (pari == true) {
			System.out.println("Pari");
		} else {
			System.out.println("Dispari");
		}
	}

	public static void verificaAnnoBisestile() {
		System.out.println("Verifica se l'anno è bisestile");
		System.out.println("Inserire l'anno da verificare seguito dal tasto Invio");
		int anno = scanner.nextInt();

		boolean bisestile = annoBisestile(anno);

		if (bisestile == true) {
			System.out.println("L'anno " + anno + " è bisestile");
		} else {
			System.out.println("L'anno " + anno + " non è bisestile");
		}
	}

	public static boolean stringaPariDispari(String stringa) {
		// Recupera il numero di caratteri che compongono la stringa
		int numCaratteri = stringa.length();

		// Usa l'operazione modulo (%) per verificare se pari o dispari
		if (numCaratteri % 2 == 0) {
			// Numero divisibile per 2, quindi pari
			return true;
		} else {
			// numero non divisibile per 2, quindi dispari
			return false;
		}
	}

	public static boolean annoBisestile(int anno) {
		if (anno % 4 == 0) {
			// Divisibile per 4
			return true;
		} else if (anno % 100 == 0 && anno % 400 == 0) {
			// Divisibile per 100 e per 400
			return true;
		}
		return false;

	}

}