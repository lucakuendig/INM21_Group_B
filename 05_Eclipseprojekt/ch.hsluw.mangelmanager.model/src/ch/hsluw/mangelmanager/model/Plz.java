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

	public Integer getPlz() {
		return plz;
	}

	public void setPlz(Integer plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

}
