package entities.joined_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "elementoByIsbn", query = "SELECT el FROM ElementoLetterario el WHERE el.isbn = :isbn")
@NamedQuery(name = "elementoByAnnoPubblicazione", query = "SELECT el FROM ElementoLetterario el WHERE el.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "elementoByAutore", query = "SELECT el FROM ElementoLetterario el WHERE lower(el.autore) = lower(:autore)")
@NamedQuery(name = "elementoByTitolo", query = "SELECT el FROM ElementoLetterario el WHERE lower(el.titolo) LIKE CONCAT('%', :titolo, '%')")

public abstract class ElementoLetterario {

	@Id
	@SequenceGenerator(name = "elementoletterario_seq", sequenceName = "elementoletterario_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elementoletterario_seq")
	private Long id;

	protected String isbn;
	protected String titolo;
	protected int annoPubblicazione;
	protected int numeroPagine;

	public ElementoLetterario() {
	} // Costruttore vuoto

	public ElementoLetterario(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine) {

		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

}
