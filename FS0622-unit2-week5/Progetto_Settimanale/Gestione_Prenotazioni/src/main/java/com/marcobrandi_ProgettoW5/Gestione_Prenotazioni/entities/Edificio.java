package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities;



import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@Table(name = "edificio")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String name;
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "citta_id")
	//@JsonManagedReference
	private Citta citta;
	
	@OneToMany(mappedBy = "edificio")
	@ToString.Exclude
	// @JsonIgnore        // ignora completamente la proprietà
	List<Postazione> postazioni;
	
}
