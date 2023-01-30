package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import utils.Evento;
import utils.Tipo;

public class App {

	private static final String persistenceUnit = "w3_giorno2_esercizio1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void insertEvento(String nome, String luogo, Tipo tipo, LocalDate data, int numMaxPartecipanti) {

		// EntityTransaction t = em.getTransaction();
		try {
			Evento e = new Evento();
			e.setNome(nome);
			e.setLuogo(luogo);
			e.setTipo(tipo);
			e.setData(data);
			e.setNumMaxPartecipanti(numMaxPartecipanti);

			t.begin();
			em.persist(e);
			t.commit();

			System.out.println("Evento inserito correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'inserimento dell'Evento");
		}

	}

	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}

	public static void getEventoById(int id) {
		Evento e = em.find(Evento.class, id);

		if (e == null) {
			System.out.println("L'Evento con l'id " + id + " non è stato trovato!");
			return;
		}

		System.out.println("Dati Evento #" + id);
		System.out.printf("Nome: %s | Luogo: %s | Tipo: %s | Data: %s | Numero massimo partecipanti: %d%n", e.getNome(),
				e.getLuogo(), e.getTipo().toString(), e.getData().toString(), e.getNumMaxPartecipanti());
	}

	public static void eliminaEventoById(int id) {
		Evento e = em.find(Evento.class, id);

		if (e == null) {
			System.out.println("L'Evento con l'id " + id + " non è stato trovato!");
			return;
		}

		t.begin();
		em.remove(e);
		t.commit();

		System.out.println("L'Evento con l'id " + id + " è stato eliminato!");
	}

	public static void closeEm() {
		em.close();
		emf.close();
	}

	public static void updateEventoById(int id, String nome, LocalDate data, Tipo tipo, String luogo,
			int numMaxPartecipanti) {
		Evento e = getEvento(id);
		if (e == null)
			return;

		try {
			e.setNome(nome);
			e.setData(data);
			e.setTipo(tipo);
			e.setLuogo(luogo);
			e.setNumMaxPartecipanti(numMaxPartecipanti);

			persist(e);

			System.out.println("L'evento con l'id " + id + " è stato aggiornato!");
		} catch (Exception ex) {
			System.out.println("Errore nella modifica dell'evento!");
		}

	}

	public static Evento getEvento(int id) {
		Evento e = em.find(Evento.class, id);

		if (e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato!");
			return null;
		}

		return e;
	}

	// Run App
	public static void main(String[] args) {

		// boolean insertEvento = true;
		// boolean eliminaEvento = true;
		boolean updateEvento = true;

		// if(insertEvento)
		// insertEvento("Partita di calcio", "Torino", Tipo.PRIVATO,
		// LocalDate.parse("2023-12-04"), 45000 );

		// if(eliminaEvento) {
		// eliminaEventoById(4);
		// }

		if (updateEvento) {
			updateEventoById(5, "Fiera di Santa Barbara", LocalDate.parse("2023-12-04"), Tipo.PUBBLICO, "Rieti",
					100000);
		}

		// getEventoById(6);

		closeEm();
	}

}
