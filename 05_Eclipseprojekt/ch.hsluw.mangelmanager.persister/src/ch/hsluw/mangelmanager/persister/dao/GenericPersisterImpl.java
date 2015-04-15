/*
 * ZWECK: Referenzprojekt
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Jordan Sucur - Februar 2015
 */
package ch.hsluw.mangelmanager.persister.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die CRUD-Methoden zur Verfügung, die in allen
 * Unterklassen vorkommen müssen.
 * 
 * @version 1.0
 * @author jsucur
 *
 * @param <T>
 * 
 */
public class GenericPersisterImpl<T> implements GenericPersister<T> {

	private static final Logger logger = Logger
			.getLogger(GenericPersisterImpl.class);

	protected Class<T> classType;

	public GenericPersisterImpl(Class<T> type) {
		this.classType = type;
	}

	@Override
	public void save(T entity) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			logger.error("Fehler beim Speichern der Entity vom Typ \'"
					+ classType.getName() + "\': [" + entity.toString() + "]",
					e);
			throw e;

		} finally {
			em.close();
		}
	}

	@Override
	public T update(T entity) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();
		em.getTransaction().begin();

		T eMerged = null;

		try {
			eMerged = em.merge(entity);

			logger.info("Entity vom Typ " + classType.getSimpleName()
					+ " wird updatet: " + entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			logger.error(
					"Fehler beim Update der Entity vom Typ \'"
							+ classType.getName() + "\': [" + entity + "]", e);
			throw e;

		} finally {
			em.close();
		}

		return eMerged;
	}

	@Override
	public void delete(T entity) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();
		em.getTransaction().begin();

		try {

			if (em.contains(entity)) {
				em.remove(entity);
			} else {
				em.remove(em.merge(entity));
			}

			logger.info("Entity vom Typ " + classType.getSimpleName() + " ["
					+ entity + "] " + " wird gelöscht");

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}

			logger.error("Fehler beim Löschen der Entity vom Typ \'"
					+ classType.getName() + "\': [" + entity + "]", e);

			throw e;

		} finally {
			em.close();
		}
	}

	@Override
	public void deleteById(Integer id) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();
		String strQuery = "DELETE FROM " + classType.getSimpleName()
				+ " entity WHERE entity.id = :id";

		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);

		try {
			em.getTransaction().begin();

			query.executeUpdate();

			logger.info("Entity vom Typ " + classType.getSimpleName()
					+ " mit id = " + id + " wird gelöscht");

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			logger.error("Fehler beim Löschen der Entity vom Typ \'"
					+ classType.getName() + "\': [ id = " + id + "]", e);
			throw e;

		} finally {
			em.close();
		}
	}

	@Override
	public T findById(Integer id) {
		return JpaUtil.createEntityManager().find(classType, id);
	}

	@Override
	public List<T> findAll() {
		String sql = "SELECT entity FROM " + classType.getSimpleName()
				+ " entity";
		TypedQuery<T> q = JpaUtil.createEntityManager().createQuery(sql,
				classType);
		return q.getResultList();
	}
}
