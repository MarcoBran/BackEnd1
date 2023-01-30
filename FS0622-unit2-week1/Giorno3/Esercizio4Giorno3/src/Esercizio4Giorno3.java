/*
 * Esercizio#4: for
 *Scrivere un programma che chieda all'utente di inserire un numero intero e stampi il conto alla rovescia a partire 
 *da quel numero fino a zero.
 */
import java.util.Scanner;

public class Esercizio4Giorno3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire un numero intero, poi premere Invio");
		int numero = scanner.nextInt();
		
		System.out.println("Conto alla rovescia da: " + numero + " a 0");
		
		for (int i = numero; i >= 0; i--) {
			System.out.println(i);
		}
		scanner.close();
	}

}
