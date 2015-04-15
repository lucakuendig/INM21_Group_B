/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
	private int id;
	private String strasse;
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Plz plz;


	public Adresse() {

	}

	
	/**
	 * @param strasse
	 * @param plz
	 * 
	 */
	public Adresse(String strasse, Plz plz) {
		super();
		this.strasse = strasse;
		this.plz = plz;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStrasse() {
		return strasse;
	}


	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public Plz getPlz() {
		return plz;
	}


	public void setPlz(Plz plz) {
		this.plz = plz;
	}

	

	

}
