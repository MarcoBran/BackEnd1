package progetto;
 //Va a gestire tutti gli elementi multimediali che possono essere riprodotti

public abstract class ElementoMultimedialeRiproducibile extends ElementoMultimediale implements RegolazioneVolume {
	
	protected int durata = 0;
	protected int volume = 0;
	
	protected ElementoMultimedialeRiproducibile(String titolo, int durata, int volume) {
		
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}
	
	protected abstract void play(); //METODO DA IMPLEMENTARE
	
	public int alzaVolume() {
		this.volume = volume + 1;
		return this.volume;
	}
	
	public int abbassaVolume() {
		//Controlla che il volume non sia gia a zero
		if(this.volume > 0) {
		this.volume = volume - 1;
		}
		return this.volume;
	}
	
	protected String creaStringaRiproduzione() {
		String riproduzione = this.titolo;
		
		//Aggiunge ! corrispondenti al volume
		for(int i = 0; i < this.volume; i++) {
			riproduzione += "!";
		}
		return riproduzione;
	}

}
