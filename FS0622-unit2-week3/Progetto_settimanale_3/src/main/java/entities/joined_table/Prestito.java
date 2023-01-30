package entities.joined_table;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "prestitoByTessera", query = "SELECT pr FROM Prestito pr WHERE pr.utente.numeroTessera = :numeroTessera")
@NamedQuery(name = "prestitoScaduto", query = "SELECT pr FROM Prestito pr WHERE pr.dataFinePrestitoPrevista < CURRENT_DATE and pr.dataFinePrestitoEffettiva IS NULL ")

public class Prestito {

	@Id
	@SequenceGenerator(name = "prestito_seq", sequenceName = "prestito_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestito_seq")
	private Long id;

	@ManyToOne // molti prestiti riferiti ad utente
	private Utente utente;

	@ManyToOne // molti prestiti riferiti ad elementoletterario
	private ElementoLetterario elementoPrestato;

	private Date dataInizioPrestito;
	private Date dataFinePrestitoPrevista;
	private Date dataFinePrestitoEffettiva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public ElementoLetterario getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(ElementoLetterario elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public Date getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(Date dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public Date getDataFinePrestitoPrevista() {
		return dataFinePrestitoPrevista;
	}

	public void setDataFinePrestitoPrevista(Date dataFinePrestitoPrevista) {
		this.dataFinePrestitoPrevista = dataFinePrestitoPrevista;
	}

	public Date getDataFinePrestitoEffettiva() {
		return dataFinePrestitoEffettiva;
	}

	public void setDataFinePrestitoEffettiva(Date dataFinePrestitoEffettiva) {
		this.dataFinePrestitoEffettiva = dataFinePrestitoEffettiva;
	}

}
