/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Diese Klasse bildet eine Adresse ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
public class Adresse implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	private String strasse;
<<<<<<< HEAD
	@ManyToOne (cascade=CascadeType.ALL)
=======
	@ManyToOne 
>>>>>>> c8a22782e1c6d3e01aaedd9de8b27e7cc18a2ec1
	private Plz plz;

	public Adresse() {

	}

	/**
	 * @param strasse
	 * @param plz
	 * 
	 */
	public Adresse(String strasse, Plz plz) {
		this.strasse = strasse;
		this.plz = plz;
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
	 * @return the strasse
	 */
	public String getStrasse() {
		return strasse;
	}

	/**
	 * @param strasse
	 *            the strasse to set
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	/**
	 * @return the plz
	 */
	public Plz getPlz() {
		return plz;
	}

	/**
	 * @param plz
	 *            the plz to set
	 */
	public void setPlz(Plz plz) {
		this.plz = plz;
	}
}
