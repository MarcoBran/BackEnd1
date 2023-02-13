package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Postazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Prenotazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.User;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{

	 @Query(
	            value = "SELECT p FROM Prenotazione p WHERE (p.user = :u AND p.data = :d) OR (p.postazione = :p AND " +
	                    "p.data= :d)"
	    )
	    public List<Prenotazione> findPrenotazioneByTipo( @Param( "u" ) User u, @Param( "d" ) LocalDate d,
	                                                      @Param( "p" ) Postazione p);
}
