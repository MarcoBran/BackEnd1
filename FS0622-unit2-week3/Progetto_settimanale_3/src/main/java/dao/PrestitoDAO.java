package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.LoggerFactory;

import entities.joined_table.Prestito;
import jpaUtil.JpaUtil;

public class PrestitoDAO {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(PrestitoDAO.class);

	public void save(Prestito object) {
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

	public void refresh(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(object);

		} finally {
			em.close();
		}
	}

	public Prestito getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Prestito.class, id);
		} finally {
			em.close();
		}
	}

	public void delete(Prestito object) {
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

	public List<Prestito> getPrestitoByNumeroTessera(String numeroTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("prestitoByTessera");

			query.setParameter("numeroTessera", numeroTessera);
			return query.getResultList;

		} finally {
			em.close();
		}
	}

	public List<Prestito> getPrestitoScaduto() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("prestitoScaduto");

			return query.getResultList;

		} finally {
			em.close();
		}
	}

}
