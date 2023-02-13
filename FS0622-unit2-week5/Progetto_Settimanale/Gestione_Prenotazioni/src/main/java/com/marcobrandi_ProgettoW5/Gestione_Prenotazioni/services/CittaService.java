package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Citta;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories.CittaRepository;

@Service
public class CittaService {
	
	@Autowired
	CittaRepository cr;
	
	public void addCitta(Citta c) {
		cr.save(c);
	}
	
	public List<Citta> getAll() {
	     return cr.findAll();
	     }
	
	  public Citta findCittaById(Long id){
	         return cr.findById(id).isPresent() ? cr.findById(id).get() : null;
	     }
	
}
