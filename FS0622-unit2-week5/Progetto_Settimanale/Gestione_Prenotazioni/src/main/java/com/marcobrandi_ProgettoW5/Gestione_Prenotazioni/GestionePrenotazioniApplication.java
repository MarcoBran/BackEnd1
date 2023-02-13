package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Citta;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Edificio;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Postazione;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.Tipo;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.User;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services.CittaService;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services.EdificioService;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services.PostazioneService;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services.PrenotazioneService;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services.UserService;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {
	@Autowired
	UserService us;
	@Autowired
	CittaService cs;
	@Autowired
	EdificioService es;
	@Autowired
	PostazioneService ps;
	@Autowired
	PrenotazioneService prs;
	public static void main(String[] args) {
		SpringApplication.run( GestionePrenotazioniApplication.class, args);
		System.out.println("hello");
	}
	@Override
	public void run(String... args) throws Exception {
		insertUser(User.builder().username("dofla").fullname("Marco Brandi").email("mb@si.com").build());
		
		insertCitta(Citta.builder().name("Tokyo").build());
		insertEdificio(Edificio.builder().name("Tokyo Tower").address("Esempio 34").citta(cs.findCittaById(52L)).build());
		insertPostazione(Postazione.builder().tipo(Tipo.SALA_RIUNIONI).maxSize(15).description("es34").edificio(es.findEdificioById(5L)).build());
		//System.out.println(ps.getByTipoAndCitta(Tipo.SALARIUNIONI, cs.findCittaById(52L)));
		//insertPrenotazione(us.findUserById(3L),ps.findPostazioneById(3L),LocalDate.now());


}
	public void insertUser(User u){
		us.addUser(u);
	}
	public void insertCitta(Citta c){
		cs.addCitta(c);
	}
	public void insertEdificio(Edificio e){
		es.addEdificio(e);
	}
	public void insertPostazione(Postazione p){
		ps.addPostazione(p);
	}
	public void insertPrenotazione(User u, Postazione p, LocalDate d){
		prs.realAddPrenotazione(u,p,d);
	}
}
