/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Diese Klasse bildet ein Projekt ab.
 * 
 * @version 1.0
 * @author sritz
 *
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Projekt.findByBezeichnung", query = "SELECT p FROM Projekt p WHERE p.bezeichnung=:bezeichnung"),
		//@NamedQuery(name = "Projekt.findByDatumFromTillEnd", query = "SELECT p FROM Projekt p WHERE p.startdatum >=:startdatum and p.enddatum <=:enddatum"),
		@NamedQuery(name = "Projekt.findByBauherr", query = "SELECT p FROM Projekt p join p.fkBauherr b where b.nachname in (:bauherr)"),
		@NamedQuery(name = "Projekt.findByPlz", query = "SELECT p FROM Projekt p WHERE p.fkAdresse.plz=:plz"),
		@NamedQuery(name = "Projekt.findByOrt", query = "SELECT p FROM Projekt p WHERE p.fkAdresse.plz.ort=:ort"),
		@NamedQuery(name = "Projekt.findByObjekttyp", query = "SELECT p FROM Projekt p WHERE p.fkObjekttyp.bezeichnung=:objekttyp"),
		@NamedQuery(name = "Projekt.findByArbeittyp", query = "SELECT p FROM Projekt p WHERE p.fkArbeitstyp.bezeichnung=:arbeitstyp"),
		@NamedQuery(name = "Projekt.findByProjektstatus", query = "SELECT p FROM Projekt p WHERE p.fkProjektstatus.bezeichnung=:projektstatus") })
public class Projekt implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Adresse fkAdresse;
	private String bezeichnung;
	private String beschreibung;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Bauherr> fkBauherr;

	@Temporal(TemporalType.DATE)
	private GregorianCalendar startDatum;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar endDatum;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Objekttyp fkObjekttyp;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Arbeitstyp fkArbeitstyp;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar faelligkeitsDatum;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Projektstatus fkProjektstatus;

	@OneToMany (cascade = CascadeType.PERSIST, mappedBy="fkProjekt", fetch = FetchType.EAGER)
	private List<Mangel> fkMaengel;
	
	public Projekt() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fkAdresse
	 * @param bezeichnung
	 * @param fkBauherr
	 * @param startDatum
	 * @param endDatum
	 * @param fkObjekttyp
	 * @param fkArbeitstyp
	 * @param faelligkeitsDatum
	 * @param fkProjektstatus
	 */
	public Projekt(Adresse fkAdresse, String bezeichnung,
			List<Bauherr> fkBauherr, GregorianCalendar startDatum,
			GregorianCalendar endDatum, Objekttyp fkObjekttyp,
			Arbeitstyp fkArbeitstyp, GregorianCalendar faelligkeitsDatum,
			Projektstatus fkProjektstatus) {
		super();
		this.fkAdresse = fkAdresse;
		this.bezeichnung = bezeichnung;
		this.fkBauherr = fkBauherr;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
		this.fkObjekttyp = fkObjekttyp;
		this.fkArbeitstyp = fkArbeitstyp;
		this.faelligkeitsDatum = faelligkeitsDatum;
		this.fkProjektstatus = fkProjektstatus;
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
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * @return the fkBauherr
	 */
	public List<Bauherr> getFkBauherr() {
		return fkBauherr;
	}

	/**
	 * @param fkBauherr the fkBauherr to set
	 */
	public void setFkBauherr(List<Bauherr> fkBauherr) {
		this.fkBauherr = fkBauherr;
	}

	/**
	 * @return the startDatum
	 */
	public GregorianCalendar getStartDatum() {
		return startDatum;
	}

	/**
	 * @param startDatum the startDatum to set
	 */
	public void setStartDatum(GregorianCalendar startDatum) {
		this.startDatum = startDatum;
	}

	/**
	 * @return the endDatum
	 */
	public GregorianCalendar getEndDatum() {
		return endDatum;
	}

	/**
	 * @param endDatum the endDatum to set
	 */
	public void setEndDatum(GregorianCalendar endDatum) {
		this.endDatum = endDatum;
	}

	/**
	 * @return the fkObjekttyp
	 */
	public Objekttyp getFkObjekttyp() {
		return fkObjekttyp;
	}

	/**
	 * @param fkObjekttyp the fkObjekttyp to set
	 */
	public void setFkObjekttyp(Objekttyp fkObjekttyp) {
		this.fkObjekttyp = fkObjekttyp;
	}

	/**
	 * @return the fkArbeitstyp
	 */
	public Arbeitstyp getFkArbeitstyp() {
		return fkArbeitstyp;
	}

	/**
	 * @param fkArbeitstyp the fkArbeitstyp to set
	 */
	public void setFkArbeitstyp(Arbeitstyp fkArbeitstyp) {
		this.fkArbeitstyp = fkArbeitstyp;
	}

	/**
	 * @return the faelligkeitsDatum
	 */
	public GregorianCalendar getFaelligkeitsDatum() {
		return faelligkeitsDatum;
	}

	/**
	 * @param faelligkeitsDatum the faelligkeitsDatum to set
	 */
	public void setFaelligkeitsDatum(GregorianCalendar faelligkeitsDatum) {
		this.faelligkeitsDatum = faelligkeitsDatum;
	}

	/**
	 * @return the fkProjektstatus
	 */
	public Projektstatus getFkProjektstatus() {
		return fkProjektstatus;
	}

	/**
	 * @param fkProjektstatus the fkProjektstatus to set
	 */
	public void setFkProjektstatus(Projektstatus fkProjektstatus) {
		this.fkProjektstatus = fkProjektstatus;
	}

	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * @param beschreibung the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * @return the fkMaengel
	 */
	public List<Mangel> getFkMaengel() {
		return fkMaengel;
	}

	/**
	 * @param fkMaengel the fkMaengel to set
	 */
	public void setFkMaengel(List<Mangel> fkMaengel) {
		this.fkMaengel = fkMaengel;
	}
	
	


	

}
