package dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.LoggerFactory;

import entities.joined_table.Utente;
import jpaUtil.JpaUtil;

public class UtenteDAO {
	private static final Logger logger = LoggerFactory.getLogger(UtenteDAO.class);

	public void save(Utente object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();

		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving oject: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}
	}

	public void refresh(Utente object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(object);

		} finally {
			em.close();
		}
	}

	public Utente getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Utente.class, id);
		} finally {
			em.close();
		}
	}

	public void delete(Utente object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();

		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

}
