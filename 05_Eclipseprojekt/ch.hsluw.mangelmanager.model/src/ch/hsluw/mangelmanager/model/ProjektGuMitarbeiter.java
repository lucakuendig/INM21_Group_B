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
 * Diese Klasse bildet eine Beziehung zwischen GuMitarbeiter und Projekt ab.
 * 
 * @version 1.0
 * @author lkuendig
 *
 */

@Entity
public class ProjektGuMitarbeiter implements Serializable {

	private static final long serialVersionUID = 5806477597388591398L;
	
	@Id
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Projekt fkProjekt;
	@Id
	@ManyToOne (cascade = CascadeType.PERSIST)
	private GuMitarbeiter fkGuMitarbeiter;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar startDatum;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar endDatum;
	
	public ProjektGuMitarbeiter(){
		
	}
	
	/**
	 * @param fkProjekt
	 * @param fkuMItarbeiter
	 * @param startDatum
	 * @param endDatum
	 * 
	 */
	
	public ProjektGuMitarbeiter(Projekt fkProjekt, GuMitarbeiter fkGuMitarbeiter, GregorianCalendar startDatum, GregorianCalendar endDatum){
		super();
		this.fkProjekt = fkProjekt;
		this.fkGuMitarbeiter = fkGuMitarbeiter;
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
	 * @return the idGuMitarbeiter
	 */
	public GuMitarbeiter getFkGuMitarbeiter() {
		return fkGuMitarbeiter;
	}

	/**
	 * @param idGuMitarbeiter the idGuMitarbeiter to set
	 */
	public void setFkGuMitarbeiter(GuMitarbeiter fkGuMitarbeiter) {
		this.fkGuMitarbeiter = fkGuMitarbeiter;
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
