package entities.joined_table;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity

public class Rivista extends ElementoLetterario {

	private Periodicita periodicita;

	public Rivista() {
	}

	public Rivista(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine,
			Periodicita periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	@Enumerated(EnumType.STRING) // gestire il valore di dato che verra stampato
	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

}
