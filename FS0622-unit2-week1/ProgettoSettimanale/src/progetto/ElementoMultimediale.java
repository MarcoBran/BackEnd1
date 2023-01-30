package progetto;

public abstract class ElementoMultimediale {
	
	protected String titolo; 
	
	protected ElementoMultimediale(String titolo) { //costruttore per inizializzare il titolo
		this.titolo = titolo;
	}
	
	//getter
	public String getTitolo() {
		return titolo;
	}
	
	//setter
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
}
