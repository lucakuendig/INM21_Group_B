/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

//	@Id
//	@GeneratedValue	
//	private Integer id;
	@OneToOne (cascade = CascadeType.ALL)
	private Adresse fkAdresse;

	public Bauherr() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * 
	 * @param nachname
	 * @param vorname
	 * @param telefon
	 * @param fkAdresse
	 */
	public Bauherr(String nachname, String vorname, String telefon,
			Adresse fkAdresse) {
		super(nachname, vorname, telefon);
		this.fkAdresse = fkAdresse;
	}

//	/**
//	 * @return the id
//	 */
//	public Integer getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Integer id) {
//		this.id = id;
//	}

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
	
	@Override
    public String toString() {
        return getNachname() + " "+ getVorname();
    }



}