package progetto;

public class Video extends ElementoMultimedialeRiproducibile implements RegolazioneLuminosa{
	
	private int luminosita = 0;
	
	protected Video(String titolo, int durata, int volume, int voluminosita) {
		super(titolo, durata, volume);
		this.luminosita = luminosita;
	}
	
	@Override
	public int alzaLuminosita() {
		this.luminosita = luminosita + 1;
		return this.luminosita;
	}
	
	@Override
	public int abbassaLuminosita() {
		//Controllo che la luminosita non sia gia a zero
		if(this.luminosita > 0) {
			this.luminosita = luminosita - 1;
		}
		return this.luminosita;
	}
	
	@Override
	protected void play() {
		String riproduzione = creaStringaRiproduzione();
		
		//Aggiunge * corrispondenti alla luminosità		
		for(int j = 0; j < this.luminosita; j++) {
			riproduzione += "*";
		}
		
		//Scrive la stringa un numero di volte pari alla durata
		for(int k = 1; k <= this.durata; k++) {
			System.out.println("Video: " + k + " - " + riproduzione);
		}
	}

}
