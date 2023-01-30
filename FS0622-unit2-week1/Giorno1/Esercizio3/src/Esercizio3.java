import java.util.Scanner;

/**ESERCIZIO 3
 * Implementare un metodo main che chiede all'utente di inserire 3 stringhe da tastiera
 * e scrive in console la concatenazione delle stringhe inordine di inserimento e 
 * e in ordine di inserimento inverso.
 * 
 */

public class Esercizio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creazione dello Scanner
		Scanner scanner = new Scanner(System.in);
		String[] stringa = new String [3];
		
		//Primo riga
		System.out.println("Inserire ogni stringa seguita dal tasto invio");
		System.out.println("prima riga");
		stringa[0] = scanner.nextLine();
		
		//Seconda riga
		System.out.println("seconda riga");
		stringa[1] = scanner.nextLine();
		
		//Terza riga
		System.out.println("terza riga");
		stringa[2] = scanner.nextLine();
		
		System.out.println("Stringhe in ordine: ");
		System.out.println(stringa[0] + " - " + stringa[1] + " - " + stringa[2]);
		
		System.out.println("Stringhe in ordine inverso: ");
		System.out.println(stringa[2] + " - " + stringa[1] + " - " + stringa[0]);
		scanner.close();
		
	}

}
