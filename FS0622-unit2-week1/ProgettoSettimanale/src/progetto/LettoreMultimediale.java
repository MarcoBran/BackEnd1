package progetto;

import java.util.Scanner;

public class LettoreMultimediale {

	public static final int DIMENSIONE_LISTA_ELEMENTI = 5;

	private ElementoMultimediale[] listaElementi;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LettoreMultimediale player = new LettoreMultimediale();

		player.start();
	}

	private void caricaListaElementi() {
		listaElementi = new ElementoMultimediale[DIMENSIONE_LISTA_ELEMENTI];
		System.out.println("*****     Caricamento lista elementi     *****");

		for (int i = 0; i < listaElementi.length; i++) {
			ElementoMultimediale elemento = caricaElemento();
			if (elemento != null) {
				listaElementi[i] = elemento;
				System.out.println("Elemento " + i + " caricato con successo.");
			} else {
				System.out.println("Elemento " + i + " non caricato, riprovare.");

				i = i - i;
			}
		}
		System.out.println("*****     Caricamento completato     *****");
	}

	private ElementoMultimediale caricaElemento() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire una stringa seguita dal tasto invio");

		System.out.println("Scegli il tipo di elemento inserendo il numero corrispondente seguito dal tasto invio");
		System.out.println(">1 - Video");
		System.out.println(">2 - Audio");
		System.out.println(">3 - Immagine");
		int scelta = scanner.nextInt();

		ElementoMultimediale elemento = null;
		switch (scelta) {
		case 1: {
			elemento = caricaVideo();
			break;
		}
		case 2: {
			elemento = caricaAudio();
			break;
		}
		case 3: {
			elemento = caricaImmagine();
			break;
		}
		default:
			System.out.println("Selezione non valida");
		}
		return elemento;
	}

	private Immagine caricaImmagine() {
		System.out.println("-Inserisci il titolo dell'immagine seguito dal tasto invio");
		Scanner scanner = new Scanner(System.in);
		String titolo = scanner.nextLine();
		System.out.println("-Insrisci la luminosità dell'immagine seguita dal tasto invio");
		int luminosita = scanner.nextInt();

		Immagine newImmagine = new Immagine(titolo, luminosita);
		return newImmagine;
	}

	private Audio caricaAudio() {
		System.out.println("-Inserisci il titolo dell'audio seguito dal tasto invio");
		Scanner scanner = new Scanner(System.in);
		String titolo = scanner.nextLine();
		System.out.println("-Inserisci la durata dell'audio seguita dal tasto invio");
		int durata = scanner.nextInt();
		System.out.println("-Inserisci il volume dell'audio seguito dal tasto invio");
		int volume = scanner.nextInt();

		Audio newAudio = new Audio(titolo, durata, volume);
		return newAudio;
	}

	private Video caricaVideo() {
		System.out.println("-Inserisci il titolo del video seguito dal tasto invio");
		Scanner scanner = new Scanner(System.in);
		String titolo = scanner.nextLine();
		System.out.println("-Inserisci la durata del video seguita dal tasto invio");
		int durata = scanner.nextInt();
		System.out.println("-Inserisci il volume del video seguito dal tasto invio");
		int volume = scanner.nextInt();
		System.out.println("-Inserisci la luminosità del video seguita dal tasto invio");
		int luminosita = scanner.nextInt();

		Video newVideo = new Video(titolo, durata, volume, luminosita);
		return newVideo;
	}

	private ElementoMultimediale selezionaElemento() {
		System.out.println();
		System.out.println("*****     Riproduzione elemento     *****");
		System.out.println("Selenziona l' elemento inserendo un valore da 1 a " + listaElementi.length
				+ " - inserisci 0 per uscire");
		Scanner scanner = new Scanner(System.in);
		int selezione = scanner.nextInt();

		if (selezione == 0) {
			return null;
		} else {
			return listaElementi[selezione - 1];
		}
	}
	
	public void start() {
		caricaListaElementi();
		
		boolean eseguiPlayer = true;
		do {
			ElementoMultimediale elementoSelezionato = selezionaElemento();
			
			if(elementoSelezionato instanceof ElementoMultimedialeRiproducibile) {
				((ElementoMultimedialeRiproducibile) elementoSelezionato).play();
			} else if(elementoSelezionato instanceof Immagine) {
				((Immagine) elementoSelezionato).show();
			} else if(elementoSelezionato == null) {
				eseguiPlayer = false;
			}
		} while(eseguiPlayer);
		System.out.println("*****     Player chiuso con successo     *****");
	}

}
