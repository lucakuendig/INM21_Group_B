/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Diese Klasse bildet eine Person ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public
abstract class Person implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	private String nachname;
	private String vorname;
	private String telefon;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nachname
	 * @param vorname
	 * @param telefon
	 */
	public Person(String nachname, String vorname, String telefon) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.telefon = telefon;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname
	 *            the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname
	 *            the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * @param telefon
	 *            the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}