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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Projekt implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Adresse fkAdresse;
	private String bezeichnung;
	
	@ManyToMany (cascade = CascadeType.PERSIST)
	private List<Bauherr> fkBauherr;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar startDatum;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar endDatum;
	
	@ManyToMany (cascade = CascadeType.PERSIST)
	private List<Objekttyp> fkObjekttyp;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Arbeitstyp fkArbeitstyp;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar faelligkeitsDatum;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Projektstatus fkProjektstatus;
	
	
	
	public Projekt() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Projekt(Adresse fkAdresse, String bezeichnung,
			List<Bauherr> fkBauherr, GregorianCalendar startDatum,
			GregorianCalendar endDatum, List<Objekttyp> fkObjekttyp,
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



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Adresse getFkAdresse() {
		return fkAdresse;
	}
	public void setFkAdresse(Adresse fkAdresse) {
		this.fkAdresse = fkAdresse;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public List<Bauherr> getFkBauherr() {
		return fkBauherr;
	}
	public void setFkBauherr(List<Bauherr> fkBauherr) {
		this.fkBauherr = fkBauherr;
	}
	public List<Objekttyp> getFkObjekttyp() {
		return fkObjekttyp;
	}
	public void setFkObjekttyp(List<Objekttyp> fkObjekttyp) {
		this.fkObjekttyp = fkObjekttyp;
	}
	public GregorianCalendar getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(GregorianCalendar startDatum) {
		this.startDatum = startDatum;
	}
	public GregorianCalendar getEndDatum() {
		return endDatum;
	}
	public void setEndDatum(GregorianCalendar endDatum) {
		this.endDatum = endDatum;
	}

	public Arbeitstyp getFkArbeitstyp() {
		return fkArbeitstyp;
	}
	public void setFkArbeitstyp(Arbeitstyp fkArbeitstyp) {
		this.fkArbeitstyp = fkArbeitstyp;
	}
	public GregorianCalendar getFaelligkeitsDatum() {
		return faelligkeitsDatum;
	}
	public void setFaelligkeitsDatum(GregorianCalendar faelligkeitsDatum) {
		this.faelligkeitsDatum = faelligkeitsDatum;
	}
	public Projektstatus getFkProjektstatus() {
		return fkProjektstatus;
	}
	public void setFkProjektstatus(Projektstatus fkProjektstatus) {
		this.fkProjektstatus = fkProjektstatus;
	}
	
	
	
	

	}


