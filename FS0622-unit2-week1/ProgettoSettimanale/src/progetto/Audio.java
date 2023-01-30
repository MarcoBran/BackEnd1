package progetto;

//Classe abstract che va a specializzare quello che mi serve
public class Audio extends ElementoMultimedialeRiproducibile {
	
	protected Audio(String titolo, int durata, int volume) {
		super(titolo, durata, volume);
	}
	
	@Override
	public void play() {
		String riproduzione = creaStringaRiproduzione();
		
		//Scrive la stringa un numero di volte pari alla durata
		for(int k = 1; k <= this.durata; k++) {
			System.out.println("Audio: " + k + " - " +  riproduzione);
		}
	}

}
