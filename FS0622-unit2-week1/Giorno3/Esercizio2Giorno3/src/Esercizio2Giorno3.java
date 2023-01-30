/*
 * Esercizio#2: switch
 * Scrivere un programma che chiede un intero in ingresso e lo stampa in lettere se il valore è compreso tra 0 e 3,
 * altrimenti stampa un messaggio d'errore usando il costrutto switch. 
 */
import java.util.Scanner;

public class Esercizio2Giorno3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Inizializza lo scanner per l'acquisizione dell'input utente
		Scanner scanner = new Scanner(System.in);
		System.out.println("Conversione numeri in lettere");
		System.out.println("Inserire un numero intero seguito dal tasto Invio");
		int numero = scanner.nextInt();// Variabile locale (int numero)
		String numeroInLettere = null; // Variabile inizializzata a null

		switch (numero) {
		case 0: {
			numeroInLettere = "Zero";
			break;
		}
		case 1: {
			numeroInLettere = "Uno";
			break;
		}
		case 2: {
			numeroInLettere = "Due";
			break;
		}
		case 3: {
			numeroInLettere = "Tre";
			break;
		}
		default:
			numeroInLettere = "Numero non compreso tra 0 e 3, impossibile conertire!";
		}
		
			System.out.println("Risultato: " + numeroInLettere);
			scanner.close();
	}

}
