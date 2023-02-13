package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Postazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories.PostazioneRepository;

@Service
public class PostazioneService {
	
	@Autowired
	PostazioneRepository postr;
	
	public void addPostazione(Postazione post) {
		postr.save(post);
	}
	
	public List<Postazione> getAll(){
		return postr.findAll();
	}
	
	public Postazione findUserById(Long id){
        return postr.findById(id).isPresent() ? postr.findById(id).get() : null;
    }
	
	//public List<Postazione> getByTipoAndCitta(Tipo tipo, Citta citta){return postr.findPostazioneByTipoAndCitta(tipo, citta);}
}
