/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import javax.persistence.*; //�ndern

/**
 * Diese Klasse bildet einen Mangel ab.
 * 
 * @version 1.0
 * @author mmont
 *
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Mangel.findByID", query = "SELECT p FROM Mangel p WHERE p.id=:id"),
		@NamedQuery(name = "Mangel.findByName", query = "SELECT p FROM Mangel p WHERE p.name=:name"),
		@NamedQuery(name = "Mangel.findByErfassungsZeit", query = "SELECT p FROM Mangel p WHERE p.erfassungsZeit <= erfassungsZeit"),
		@NamedQuery(name = "Mangel.findByFaelligkeitsDatum", query = "SELECT p FROM Mangel p WHERE p.faelligkeitsDatum=:faelligkeitsDatum"),
		@NamedQuery(name = "Mangel.findByMangelstatus", query = "SELECT p FROM Mangel p WHERE p.fkMangelstatus=:mangelstatus"),
		@NamedQuery(name = "Mangel.findByBezeichnung", query = "SELECT p FROM Mangel p WHERE p.bezeichnung=:bezeichnung"),
		@NamedQuery(name = "Mangel.findByAbschlussZeit", query = "SELECT p FROM Mangel p WHERE p.abschlussZeit <= abschlussZeit"), })


abstract class Mangel implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Integer fkProjekt;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp erfassungsZeit;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp abschlussZeit;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar faelligkeitsDatum;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Integer fkMangelstatus;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Integer fkLogin;
	private String bezeichnung;

	/**
	 * Constructor
	 */
	public Mangel(Integer id, Integer fkProjekt, String name,
			Timestamp erfassungsZeit, Timestamp abschlussZeit,
			GregorianCalendar faelligkeitsDatum, Integer fkMangelstatus,
			Integer fkLogin, String bezeichnung) {
		super();
		this.id = id;
		this.fkProjekt = fkProjekt;
		this.name = name;
		this.erfassungsZeit = erfassungsZeit;
		this.abschlussZeit = abschlussZeit;
		this.faelligkeitsDatum = faelligkeitsDatum;
		this.fkMangelstatus = fkMangelstatus;
		this.fkLogin = fkLogin;
		this.bezeichnung = bezeichnung;
	}

	
	//Getters and Setters
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
	public Integer getFkProjekt() {
		return fkProjekt;
	}

	/**
	 * @param fkProjekt
	 *            the fkProjekt to set
	 */
	public void setFkProjekt(Integer fkProjekt) {
		this.fkProjekt = fkProjekt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the erfassungsZeit
	 */
	public Timestamp getErfassungsZeit() {
		return erfassungsZeit;
	}

	/**
	 * @param erfassungsZeit
	 *            the erfassungsZeit to set
	 */
	public void setErfassungsZeit(Timestamp erfassungsZeit) {
		this.erfassungsZeit = erfassungsZeit;
	}

	/**
	 * @return the abschlussZeit
	 */
	public Timestamp getAbschlussZeit() {
		return abschlussZeit;
	}

	/**
	 * @param abschlussZeit
	 *            the abschlussZeit to set
	 */
	public void setAbschlussZeit(Timestamp abschlussZeit) {
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
	public Integer getFkMangelstatus() {
		return fkMangelstatus;
	}

	/**
	 * @param fkMangelstatus
	 *            the fkMangelstatus to set
	 */
	public void setFkMangelstatus(Integer fkMangelstatus) {
		this.fkMangelstatus = fkMangelstatus;
	}

	/**
	 * @return the fkLogin
	 */
	public Integer getFkLogin() {
		return fkLogin;
	}

	/**
	 * @param fkLogin
	 *            the fkLogin to set
	 */
	public void setFkLogin(Integer fkLogin) {
		this.fkLogin = fkLogin;
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

}