package progetto;

public class Immagine extends ElementoMultimediale implements RegolazioneLuminosa {
	
	private int luminosita = 0; //valore iniziale di luminosità
	
	protected Immagine(String titolo, int luminosita) { //Costruttore
		super(titolo); //titolo ripreso dal "super" ovvero "ElementoMultimediale"
		this.luminosita = luminosita;
	}
	
	@Override
	public int alzaLuminosita() {
		this.luminosita = luminosita +1;
		return this.luminosita;
	}
	
	@Override
	public int abbassaLuminosita() {
		//Controllo che la luminosità non sia gia al minimo (0)
		if(this.luminosita > 0) {
			this.luminosita = luminosita -1;
		}
		return this.luminosita;
	}
	
	public void show() {
		String visualizzazione = this.titolo;
		
		for(int i = 0; i < luminosita; i++) {
			visualizzazione += "*";
		}
		System.out.println("Immagine: " + visualizzazione);
	}
}
