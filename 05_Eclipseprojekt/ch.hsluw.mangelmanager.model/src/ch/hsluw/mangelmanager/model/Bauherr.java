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
import javax.persistence.OneToOne;

/**
 * Diese Klasse bildet ein Bauherr ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
public class Bauherr extends Person implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private int id;
	@OneToOne (cascade = CascadeType.PERSIST)
	private Adresse fkAdresse;

	public Bauherr() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Bauherr(String nachname, String vorname, String telefon,
			Adresse fkAdresse) {
		super(nachname, vorname, telefon);
		this.fkAdresse = fkAdresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getFkAdresse() {
		return fkAdresse;
	}

	public void setFkAdresse(Adresse fkAdresse) {
		this.fkAdresse = fkAdresse;
	}

}