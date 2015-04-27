/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Diese Klasse bildet einen Meldungstyp ab.
 * 
 * @version 1.0
 * @author cdemir
 *
 */

@Entity
public class Meldungstyp implements Serializable {

	private static final long serialVersionUID = 6358290611507121648L;

	@Id
	@GeneratedValue
	private Integer id;
	private String bezeichnung;

	public Meldungstyp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bezeichnung
	 */
	public Meldungstyp(String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @param bezeichnung
	 *            the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}