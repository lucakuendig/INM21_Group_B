/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Diese Klasse bildet einen Mangel ab.
 * 
 * @version 1.0
 * @author mmont
 *
 */

@Entity
public class Mangel implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Projekt fkProjekt;
	private String bezeichnung;
	private String beschreibung;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar erfassungsZeit;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar abschlussZeit;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar faelligkeitsDatum;
	@ManyToOne 
	private Mangelstatus fkMangelstatus;
	@ManyToOne
	private Login fkLogin;
	

	public Mangel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor
	 */
	public Mangel(Projekt fkProjekt, String bezeichnung,
			GregorianCalendar erfassungsZeit,
			GregorianCalendar faelligkeitsDatum, Mangelstatus fkMangelstatus,
			Login fkLogin, String beschreibung) {
		super();
		this.fkProjekt = fkProjekt;
		this.bezeichnung = bezeichnung;
		this.erfassungsZeit = erfassungsZeit;
		this.abschlussZeit = abschlussZeit;
		this.faelligkeitsDatum = faelligkeitsDatum;
		this.fkMangelstatus = fkMangelstatus;
		this.fkLogin = fkLogin;
		this.beschreibung = beschreibung;
	}

	// Getters and Setters
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
	 * @return the fkProjekt
	 */
	public Projekt getFkProjekt() {
		return fkProjekt;
	}

	/**
	 * @param fkProjekt
	 *            the fkProjekt to set
	 */
	public void setFkProjekt(Projekt fkProjekt) {
		this.fkProjekt = fkProjekt;
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

	/**
	 * @return the erfassungsZeit
	 */
	public GregorianCalendar getErfassungsZeit() {
		return erfassungsZeit;
	}

	/**
	 * @param erfassungsZeit
	 *            the erfassungsZeit to set
	 */
	public void setErfassungsZeit(GregorianCalendar erfassungsZeit) {
		this.erfassungsZeit = erfassungsZeit;
	}

	/**
	 * @return the abschlussZeit
	 */
	public GregorianCalendar getAbschlussZeit() {
		return abschlussZeit;
	}

	/**
	 * @param abschlussZeit
	 *            the abschlussZeit to set
	 */
	public void setAbschlussZeit(GregorianCalendar abschlussZeit) {
		this.abschlussZeit = abschlussZeit;
	}

	/**
	 * @return the faelligkeitsDatum
	 */
	public GregorianCalendar getFaelligkeitsDatum() {
		return faelligkeitsDatum;
	}

	/**
	 * @param faelligkeitsDatum
	 *            the faelligkeitsDatum to set
	 */
	public void setFaelligkeitsDatum(GregorianCalendar faelligkeitsDatum) {
		this.faelligkeitsDatum = faelligkeitsDatum;
	}

	/**
	 * @return the fkMangelstatus
	 */
	public Mangelstatus getFkMangelstatus() {
		return fkMangelstatus;
	}

	/**
	 * @param fkMangelstatus
	 *            the fkMangelstatus to set
	 */
	public void setFkMangelstatus(Mangelstatus fkMangelstatus) {
		this.fkMangelstatus = fkMangelstatus;
	}

	/**
	 * @return the fkLogin
	 */
	public Login getFkLogin() {
		return fkLogin;
	}

	/**
	 * @param fkLogin
	 *            the fkLogin to set
	 */
	public void setFkLogin(Login fkLogin) {
		this.fkLogin = fkLogin;
	}

	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * @param beschreibung
	 *            the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	@Override
    public String toString() {
        return id +" - " +  bezeichnung;
    }
	
	
	

}