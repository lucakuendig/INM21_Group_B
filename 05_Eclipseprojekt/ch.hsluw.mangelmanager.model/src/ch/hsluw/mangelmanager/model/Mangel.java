/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;

/**
 * Diese Klasse bildet einen Mangel ab.
 * 
 * @version 1.0
 * @author mmont
 *
 */

@Entity
//@NamedQueries({
//		@NamedQuery(name = "Mangel.findByID", query = "SELECT p FROM Mangel p WHERE p.id=:id"),
//		@NamedQuery(name = "Mangel.findByName", query = "SELECT p FROM Mangel p WHERE p.name=:name"),
//		@NamedQuery(name = "Mangel.findByErfassungsZeit", query = "SELECT p FROM Mangel p WHERE p.erfassungsZeit=:erfassungsZeit"),
//		@NamedQuery(name = "Mangel.findByFaelligkeitsDatum", query = "SELECT p FROM Mangel p WHERE p.faelligkeitsDatum=:faelligkeitsDatum"),
//		@NamedQuery(name = "Mangel.findByMangelstatus", query = "SELECT p FROM Mangel p WHERE p.fkMangelstatus=:mangelstatus"),
//		@NamedQuery(name = "Mangel.findByBezeichnung", query = "SELECT p FROM Mangel p WHERE p.bezeichnung=:bezeichnung"),
//		@NamedQuery(name = "Mangel.findByAbschlussZeit", query = "SELECT p FROM Mangel p WHERE p.abschlussZeit=:abschlussZeit"), })
public class Mangel implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Projekt fkProjekt;
	private String name;
	private String beschreibung;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar erfassungsZeit;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar abschlussZeit;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar faelligkeitsDatum;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Mangelstatus fkMangelstatus;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Login fkLogin;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="fkMangel", fetch = FetchType.EAGER)
	private List<Meldung> fkMeldung;

	public Mangel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor
	 */
	public Mangel(Integer id, Projekt fkProjekt, String name,
			GregorianCalendar erfassungsZeit, GregorianCalendar abschlussZeit,
			GregorianCalendar faelligkeitsDatum, Mangelstatus fkMangelstatus,
			Login fkLogin, String beschreibung) {
		super();
		this.id = id;
		this.fkProjekt = fkProjekt;
		this.name = name;
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
	/**
	 * @return the fkMeldung
	 */
	public List<Meldung> getFkMeldung() {
		return fkMeldung;
	}
	/**
	 * @param fkMeldung the fkMeldung to set
	 */
	public void setFkMeldung(List<Meldung> fkMeldung) {
		this.fkMeldung = fkMeldung;
	}
	
	

}