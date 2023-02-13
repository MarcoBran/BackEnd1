package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Edificio;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories.EdificioRepository;

@Service
public class EdificioService {
	  @Autowired
	    EdificioRepository er;

	    public void addEdificio(Edificio e){
	        er.save(e);
	    }

	    public List<Edificio> getAll() {
	        return er.findAll();
	    }

	    public Edificio findEdificioById(Long id){
	        return er.findById(id).isPresent() ? er.findById(id).get() : null;
	    }
}
