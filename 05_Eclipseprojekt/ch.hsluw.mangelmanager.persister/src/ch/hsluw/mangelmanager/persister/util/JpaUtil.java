/*
 * ZWECK: Referenzprojekt
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Jordan Sucur - Februar 2015
 */
package ch.hsluw.mangelmanager.persister.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Diese Klasse bildetet eine Hilfsklasse ab, die sich um die Erstellung der
 * EntityManager-Instanz kümmert.
 * 
 * @version 1.0
 * @author jsucur
 *
 */
public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory = null;

	static {
		try {
			/* EntityManagerFactory erzeugen */
			entityManagerFactory = Persistence
					.createEntityManagerFactory("MangelManagerPU");
		} catch (Throwable e) {
			/* TODO - Fehlerbehandlung … */
			e.printStackTrace();
		}
	}

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}