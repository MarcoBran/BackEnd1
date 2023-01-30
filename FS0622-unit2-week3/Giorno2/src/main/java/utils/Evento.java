package utils;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evento")

public class Evento {

	// COLONNE DELLA TABELLA

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // fa in modo che dia un valore seriale, auto-incrementante
	private int id;
	// '@Column'--> ti permette di sovrascrivere il nome della proprietà su cui è
	// applicata, che verrebbe altrimenti preso come nome della colonna generata.
	private String nome;

	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String luogo;
	private LocalDate data;
	private int numMaxPartecipanti;

	// GETTERS / SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumMaxPartecipanti() {
		return numMaxPartecipanti;
	}

	public void setNumMaxPartecipanti(int numMaxPartecipanti) {
		this.numMaxPartecipanti = numMaxPartecipanti;
	}

}
