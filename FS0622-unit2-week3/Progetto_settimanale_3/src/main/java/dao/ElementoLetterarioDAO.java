package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;

import entities.joined_table.ElementoLetterario;
import jpaUtil.JpaUtil;

public class ElementoLetterarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(ElementoLetterario.class);

	public void save(ElementoLetterario object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void refresh(ElementoLetterario object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.refresh(object);
		} finally {
			em.close();
		}
	}

	public ElementoLetterario getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(ElementoLetterario.class, id);
		} finally {
			em.close();
		}
	}

	public void delete(ElementoLetterario object) {
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

	public void deleteByIsbn(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createQuery("DELETE FROM ElementoLetterario el WHERE el.isbn = :isbn"); // attributo 'isbn'
																										// deve essere
																										// uguale al
																										// parametro che
																										// gl passiamo

			query.setParameter("isbn", isbn);

			query.executeUpdate();

			transaction.commit();

		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + isbn, ex);
		} finally {
			em.close();
		}
	}

	public List<ElementoLetterario> getElementiByIsbn(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("elementoByIsbn");

			query.setParameter("isbn", isbn);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

}
