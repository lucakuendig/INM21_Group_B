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
@Inheritance(strategy=InheritanceType.JOINED)
abstract class Person implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private int id;
	private String nachname;
	private String vorname;
	private String telefon;
	
	public Person(String nachname, String vorname, String telefon) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		this.telefon = telefon;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	
	
	
	
	
	
	

	


}