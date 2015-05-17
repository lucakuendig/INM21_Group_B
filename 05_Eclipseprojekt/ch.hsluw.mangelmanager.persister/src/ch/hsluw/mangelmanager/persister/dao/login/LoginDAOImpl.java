package ch.hsluw.mangelmanager.persister.dao.login;
/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;
import ch.hsluw.mangelmanager.persister.util.JpaUtil;

/**
 * Interface fuer Login Entity
 * 
 * @version 1.0
 * @author miten
 * 
 */
public class LoginDAOImpl implements LoginDAO {
	@Override
	public void save(Login entity) throws Exception {
		new GenericPersisterImpl<Login>(Login.class).save(entity);
	}

	@Override
	public Login update(Login entity) throws Exception {
		return new GenericPersisterImpl<Login>(Login.class).update(entity);
	}

	@Override
	public void delete(Login entity) throws Exception {
		new GenericPersisterImpl<Login>(Login.class).delete(entity);
	}
	
	@Override
	public void deleteLoginById(Integer id) throws Exception {
		new GenericPersisterImpl<Login>(Login.class).deleteById(id);
	}

	@Override
	public Login findLoginById(Integer id) {
		return new GenericPersisterImpl<Login>(Login.class).findById(id);
	}

	@Override
	public List<Login> findAllLogin() {
		return new GenericPersisterImpl<Login>(Login.class).findAll();
	}

	@Override
	public Login findByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();
		
		TypedQuery<Login> tQuery = em.createNamedQuery("Login.findByName",
				Login.class);
		
		tQuery.setParameter("loginName", name);
		
		try{
		Login login = tQuery.getSingleResult();
		em.close();
		return login;
		} catch(NoResultException e) {
			em.close();
	        return null;
	    }
		
	}
	
}
