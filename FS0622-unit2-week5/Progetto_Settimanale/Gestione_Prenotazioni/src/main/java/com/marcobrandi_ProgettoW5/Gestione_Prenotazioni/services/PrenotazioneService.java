package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Postazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Prenotazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.User;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	@Autowired
    PrenotazioneRepository prer;

    public List<Prenotazione> getAll() {
        return prer.findAll();
    }

    public Prenotazione findPrenotazioneById(Long id){
        return prer.findById(id).isPresent() ? prer.findById(id).get() : null;
    }

    public void realAddPrenotazione(User u, Postazione p, LocalDate d){
        Prenotazione prenotazione = Prenotazione.builder().user(u).data(d).postazione(p).build();
        List<Prenotazione> list = prer.findPrenotazioneByTipo(u,d,p);
        if (list.size()==0){
        	prer.save(prenotazione);
        }else{
            System.out.println("Non puoi !");
        }
}
}
