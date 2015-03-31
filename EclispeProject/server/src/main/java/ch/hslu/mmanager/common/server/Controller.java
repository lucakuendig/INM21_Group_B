package ch.hslu.mmanager.common.server;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.hslu.mmanager.common.dao.DAO;
import ch.hslu.mmanger.common.JpaUtil;


public class Controller<T, Id extends Serializable> implements DAO<T, Id> {

	private EntityManager em = null;
	private final Class<T> clazz;

	public Controller(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void persist(T t) {
		em = JpaUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public T getById(Id id) {
		em = JpaUtil.createEntityManager();
		return em.find(clazz, id);
	}

	public List<T> getAll() {
		em = JpaUtil.createEntityManager();
		TypedQuery<T> query = em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t", clazz);
		return (List<T>) query.getResultList();
	}

	public void update(T t) {
		em = JpaUtil.createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(T t) {
		em = JpaUtil.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAll() {
		em = JpaUtil.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM " + clazz.getSimpleName() + " t").executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
}