/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Diese Klasse bildet eine Plz ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
public class Plz implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	private Integer plz;
	private String ort;

	public Plz() {

	}

	/**
	 * @param plz
	 * @param ort
	 * 
	 */
	public Plz(Integer plz, String ort) {
		this.plz = plz;
		this.ort = ort;
	}

	/**
	 * @return the plz
	 */
	public Integer getPlz() {
		return plz;
	}

	/**
	 * @param plz
	 *            the plz to set
	 */
	public void setPlz(Integer plz) {
		this.plz = plz;
	}

	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * @param ort
	 *            the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

}
