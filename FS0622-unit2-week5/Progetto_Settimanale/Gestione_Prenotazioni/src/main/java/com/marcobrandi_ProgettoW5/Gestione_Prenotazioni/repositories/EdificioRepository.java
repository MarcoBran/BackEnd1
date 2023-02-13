package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Citta;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Edificio;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Postazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Tipo;

public interface EdificioRepository extends JpaRepository<Edificio, Long>{
	
	@Query(
            value = "SELECT p FROM Postazione p WHERE p.tipo = :t AND p.edificio.citta = :c"
    )
	public List<Postazione> findPostazioneByTipoAndCitta( @Param( "t") Tipo t, @Param( "c" ) Citta c);
}
