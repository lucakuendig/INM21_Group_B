/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Diese Klasse bildet eine Beziehung zwischen SuMitarbeiter und Projekt ab.
 * 
 * @version 1.0
 * @author lkuendig
 *
 */

@Entity
public class ProjektSuMitarbeiter implements Serializable {

	private static final long serialVersionUID = 8347794435492517717L;
	
	@Id
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Projekt fkProjekt;
	@Id
	@ManyToOne (cascade = CascadeType.PERSIST)
	private SuMitarbeiter fkSuMitarbeiter;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar startDatum;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar endDatum;
	
	public ProjektSuMitarbeiter(){
		
	}
	
	/**
	 * @param idProjekt
	 * @param idSuMItarbeiter
	 * @param startDatum
	 * @param endDatum
	 * 
	 */
	
	public ProjektSuMitarbeiter(Projekt fkProjekt, SuMitarbeiter fkSuMitarbeiter, GregorianCalendar startDatum, GregorianCalendar endDatum){
		this.fkProjekt = fkProjekt;
		this.fkSuMitarbeiter = fkSuMitarbeiter;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
	}

	/**
	 * @return the idProjekt
	 */
	public Projekt getFkProjekt() {
		return fkProjekt;
	}

	/**
	 * @param idProjekt the idProjekt to set
	 */
	public void setFkProjekt(Projekt fkProjekt) {
		this.fkProjekt = fkProjekt;
	}

	/**
	 * @return the idSuMitarbeiter
	 */
	public SuMitarbeiter getFkSuMitarbeiter() {
		return fkSuMitarbeiter;
	}

	/**
	 * @param idSuMitarbeiter the idSuMitarbeiter to set
	 */
	public void setFkSuMitarbeiter(SuMitarbeiter fkSuMitarbeiter) {
		this.fkSuMitarbeiter = fkSuMitarbeiter;
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
	
	
}
