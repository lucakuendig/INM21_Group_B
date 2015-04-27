package ch.hsluw.mangelmanager.persister.dao;

/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */


import java.util.List;


import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.persister.generic.GenericPersisterImpl;


/**
 * Interface fuer Mangel Entity
 * 
 * @version 1.0
 * @author mmont
 * 
 */
public class MangelstatusDAOImpl implements MangelstatusDAO {

	@Override
	public void save(Mangelstatus entity) throws Exception {
		new GenericPersisterImpl<Mangelstatus>(Mangelstatus.class).save(entity);

	}

	@Override
	public Mangelstatus update(Mangelstatus entity) throws Exception {
		return new GenericPersisterImpl<Mangelstatus>(Mangelstatus.class)
				.update(entity);

	}

	@Override
	public void delete(Mangelstatus entity) throws Exception {
		new GenericPersisterImpl<Mangelstatus>(Mangelstatus.class)
				.delete(entity);

	}

	@Override
	public void deleteMangelstatusById(Integer id) throws Exception {
		new GenericPersisterImpl<Mangelstatus>(Mangelstatus.class)
				.deleteById(id);
	}

	@Override
	public Mangelstatus findMangelstatusById(Integer id) {
		return new GenericPersisterImpl<Mangelstatus>(Mangelstatus.class)
				.findById(id);
	}

	@Override
	public List<Mangelstatus> findAllMangelstatus() {
		return new GenericPersisterImpl<Mangelstatus>(Mangelstatus.class)
				.findAll();

	}
}
