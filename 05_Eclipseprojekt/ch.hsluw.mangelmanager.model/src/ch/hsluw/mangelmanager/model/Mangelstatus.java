/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Diese Klasse zeigt den Status eines Mangels auf.
 * 
 * @version 1.0
 * @author mmont
 *
 */

@Entity
abstract class Mangelstatus implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	private String bezeichnung;

	public Mangelstatus(Integer id, String bezeichnung) {
		this.id = id;
		this.bezeichnung = bezeichnung;
	}

	public Mangelstatus() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

}