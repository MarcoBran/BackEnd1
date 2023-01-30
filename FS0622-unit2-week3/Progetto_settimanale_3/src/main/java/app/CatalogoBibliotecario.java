package app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dao.ElementoLetterarioDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import entities.joined_table.Libro;
import entities.joined_table.Periodicita;
import entities.joined_table.Prestito;
import entities.joined_table.Rivista;
import entities.joined_table.Sesso;
import entities.joined_table.Utente;

public class CatalogoBibliotecario {

	private static List<Prestito> listPrestito = new ArrayList<Prestito>();

	public static void main(String[] args) {

		popolaDb();

		ElementoLetterarioDAO elDao = new ElementoLetterarioDAO();

		elDao.getElementiByIsbn("12345");
		// elDAO.deleteByIsbn("12345");

		PrestitoDAO prDao = new PrestitoDAO();

		listPrestito = prDao.getPrestitoByNumeroTessera("12345");
		System.out.println("Nominativi delle persone che hanno attualmente in corso una prenotazione");
		AtomicInteger counterPrestitoByNumeroTessera = new AtomicInteger();
		listPrestito.forEach(prestito -> System.out.println(
				"Numero(" + counterPrestitoByNumeroTessera.getAndIncrement() + ") " + prestito.getUtente().toString()));
		listPrestito.clear();
		listPrestito = prDao.getPrestitoScaduto();
		System.out.println("Nominativi delle persone che hanno una prenotazione scaduta: ");
		AtomicInteger counterPrestitoScaduto = new AtomicInteger();
		listPrestito.forEach(prestito -> System.out.println(
				"Numero(" + counterPrestitoScaduto.getAndIncrement() + ") " + prestito.getUtente().toString()));
	}

	private static void popolaDb() {
		Libro libro = saveLibro();
		Rivista rivista = saveRivista();
		Utente utente = saveUtente();

		Prestito prestitoInCorso = savePrestitoInCorso(utente, rivista);
		Prestito prestitoScaduto = savePrestitoScaduto(utente, libro);

		PrestitoDAO savePrestito = new PrestitoDAO();
		savePrestito.save(prestitoInCorso);
		savePrestito.save(prestitoScaduto);
	}

	private static Prestito savePrestitoInCorso(Utente utente, Rivista rivista) {
		Prestito prestito = new Prestito();
		prestito.setElementoPrestato(rivista);
		prestito.setUtente(utente);
		Date dataInizio = DateUtils.addDay(new Date(), -15);
		prestito.setDataInizioPrestito(dataInizio);
		prestito.setDataFinePrestitoPrevista(DateUtils.addDays(dataInizio, 30));

		return prestito;
	}

	private static Prestito savePrestitoScaduto(Utente utente, Libro libro) {
		Prestito prestito = new Prestito();
		prestito.setElementoPrestato(libro);
		prestito.setUtente(utente);
		Date dataInizio = DateUtils.addDay(new Date(), -15);
		prestito.setDataInizioPrestito(dataInizio);
		prestito.setDataFinePrestitoPrevista(DateUtils.addDays(dataInizio, 30));

		return prestito;
	}

	private static Utente saveUtente() {
		Utente utente = new Utente();
		utente.setCognome("Rossi");
		utente.setNome("Mirko");
		utente.setDataDiNascita(java.sql.Date.valueOf("1991-03-24"));
		utente.setEmail("mirkored@nowhere.com");
		utente.setNumeroTessera("12345");
		utente.setSesso(Sesso.MASCHIO);

		UtenteDAO utDao = new UtenteDAO();
		utDao.save(utente);

		return utente;
	}

	private static Libro saveLibro() {
		Libro libro = new Libro();
		libro.setAnnoPubblicazione(2021);
		libro.setAutore("Donato Carrisi");
		libro.setIsbn("236541365");
		libro.setNumeroPagine(230);
		libro.setTitolo("Ciao");

		ElementoLetterarioDAO elDao = new ElementoLetterarioDAO();
		elDao.save(libro);
		return libro;
	}

	private static Rivista saveRivista() {
		Rivista rivista = new Rivista();
		rivista.setAnnoPubblicazione(2020);
		rivista.setIsbn("74158525");
		rivista.setNumeroPagine(54);
		rivista.setTitolo("QuattroRuote");
		rivista.setPeriodicita(Periodicita.SETTIMANALE);
		ElementoLetterarioDAO elDao = new ElementoLetterarioDAO();
		elDao.save(rivista);
		return rivista;
	}

}
