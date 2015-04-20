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

/**
 * Diese Klasse bildet ein Arbeitstyp ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
public class Arbeitstyp implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue	
	private int id;
	private String bezeichnung;
	
	public Arbeitstyp() {
		// TODO Auto-generated constructor stub
	}
	
	public Arbeitstyp(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	


}