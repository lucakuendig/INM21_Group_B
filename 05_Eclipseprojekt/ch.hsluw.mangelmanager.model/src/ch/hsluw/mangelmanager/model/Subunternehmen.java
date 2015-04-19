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
 * Diese Klasse bildet ein Subunternehmen ab.
 * 
 * @version 1.0
 * @author lkuendig
 *
 */

@Entity
public class Subunternehmen implements Serializable {
	

	private static final long serialVersionUID = -2526718021212938075L;
	
	@Id
	@GeneratedValue
	private int id;
	@OneToOne (cascade = CascadeType.PERSIST)
	private Adresse fkAdresse;
	private String name;
	private String telefon;
	
	public Subunternehmen() {
		
	}
	
	/**
	 * @param id
	 * @param adresse
	 * @param name
	 * @param telefon
	 * 
	 */
	public Subunternehmen(int id, Adresse fkAdresse, String name, String telefon){
		super();
		this.id = id;
		this.fkAdresse = fkAdresse;
		this.name = name;
		this.telefon = telefon;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fkAdresse
	 */
	public Adresse getFkAdresse() {
		return fkAdresse;
	}

	/**
	 * @param fkAdresse the fkAdresse to set
	 */
	public void setFkAdresse(Adresse fkAdresse) {
		this.fkAdresse = fkAdresse;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * @param telefon the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	
}
