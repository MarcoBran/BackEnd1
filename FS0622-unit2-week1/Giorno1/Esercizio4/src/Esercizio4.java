import java.util.Scanner;

public class Esercizio4 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		calcolaPerimetroRettangolo();
		
		calcolaPariDispari();
		
		calcolaAreaTriangolo();

	}
	
	public static double areaTriangolo(double l1, double l2, double l3 ) {
		//formula di Erone: area = sqrt(p*(p-l1)*(p-l2)*(p-l3))
		//dove p è il perimetro fel triangolo
		
		//Calcola il semiperimetro
		double p = (l1 + l2+ l3)/2;
		
		//calcola il radicando
		double radicando = p*(p-l1)*(p-l2)*(p-l3);
		
		//calcola la radice quadrata usando la funzione Math.sqrt()
		double area = Math.sqrt(radicando);
		
		return area;
	}
	
	public static int pariDispari(int numero) {
		//l'operatore modulo (%) restituisce il resto della divisione di due numeri
		return (numero % 2);
	}
	
	public static double perimetroRettangolo(double l1, double l2) {
		//La moltiplicazione ha precedenza sull'addizione
		double perimetro = l1 * 2 + l2 * 2;
		
		return perimetro;
	}
	
	public static void calcolaPerimetroRettangolo() {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Calcolo perimetro rettangolo");
		System.out.println("");
		System.out.println("Inserire la lunghezza di ogni lato seguita dal tasto invio");
		System.out.println("");
		System.out.println("Primo lato: ");
		double l1 = scanner.nextDouble();
		System.out.println("");
		System.out.println("Secondo lato: ");
		double l2 = scanner.nextDouble();
		System.out.println("");
		double perimetro = perimetroRettangolo(l1, l2);
		System.out.println("Perimetro rettangolo: " + perimetro);
		System.out.println("");
		//scanner.close();
	}
	
	public static void calcolaAreaTriangolo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Calcolo area triangolo");
		System.out.println("");
		System.out.println("Inserire la lunghezza di ogni lato seguita dal tasto invio");
		System.out.println("");
		System.out.println("Primo lato: ");
		double l1 = scanner.nextDouble();
		System.out.println("");
		System.out.println("Secondo lato: ");
		double l2 = scanner.nextDouble();
		System.out.println("");
		System.out.println("Terzo lato: ");
		double l3 = scanner.nextDouble();
		System.out.println("");
		double area = areaTriangolo(l1, l2, l3);
		System.out.println("Area triangolo: " + area);
		System.out.println("");
		System.out.println("");
		//scanner.close();
	}
	
	public static void calcolaPariDispari() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pari o dispari");
		System.out.println("");
		System.out.println("Inserire un numero intero seguita dal tasto invio");
		int numero = scanner.nextInt();
		System.out.println("");
		int pariDispari = pariDispari(numero);
		System.out.println("0 se il numero è pari, 1 se il numero è dispari: " + pariDispari);
		System.out.println("");
		//scanner.close();
		
		
	}

}
