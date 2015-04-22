/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Diese Klasse bildet ein Objekttyp ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
@NamedQueries({ @NamedQuery(name = "Objekttyp.findByBezeichnung", query = "SELECT o FROM Objekttyp o WHERE o.bezeichnung=:bezeichnung") })
public class Objekttyp implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	private String bezeichnung;

	public Objekttyp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bezeichnung
	 */
	public Objekttyp(String bezeichnung) {
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