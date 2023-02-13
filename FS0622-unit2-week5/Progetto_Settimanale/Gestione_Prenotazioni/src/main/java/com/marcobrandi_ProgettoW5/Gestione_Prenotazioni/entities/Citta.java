package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Citta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToMany(mappedBy = "citta")
	@ToString.Exclude
	// @JsonIgnore
	// @JsonBackReference
	private List<Edificio> edifici;
	private String name;

	public Citta(String name) {
		this.name = name;
	}
}
