/**Esercizio #2
 *Implementa i seguenti metodi:
 *Moltiplica: accetta due interi e ritorna il loro prodotto;
 *Concatena: accetta una stringa e un intero e restituisce una stringa che concatena gli elementi:
 *InserisciInArray: accetta un array di stringhe di 5 elementi ed una stringa,
 *e restituisca un array di 6 elementi in cui la stringa passata sia al terzo posto
 *e le stringhe precedentemente in quarta e quinta posizione siano rispettivamente
 *quinta e sesta.
 *Scrivere una Main che invochi in sequenza i 3 metodi realizzati. 
 */

public class Esercizio2 {

	
	public static void main(String[] args) {
		String[] a = new String[5];
		a[0] = "A";
		a[1] = "B";
		a[2] = "C";
		a[3] = "D";
		a[4] = "E";
		
		//Print
		System.out.println(moltiplica(10, 5));
		System.out.println(concatena("Marco", 29));
		System.out.println(inserisciInArray(a, "Z"));
	}
	
		//METODI
		
		//Moltiplicazione
		static int moltiplica(int a, int b) {
			return a*b;
		}
		
		//Concatena
		static String concatena(String a, int b) {
			return a + " is " + b + " years old "; 
		}
		
		//inserisciInArray
		static String inserisciInArray(String[] a, String b) {
			String[] c = new String[6];
			c[0] = a[0];
			c[1] = a[1];
			c[2] = a[2];
			c[3] = b;
			c[4] = a[3];
			c[5] = a[4];
			return java.util.Arrays.toString(c);
		}
	}


