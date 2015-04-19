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
	private int idProjekt;
	@Id
	@ManyToOne (cascade = CascadeType.PERSIST)
	private int idGuMitarbeiter;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar startDatum;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar endDatum;
	
	public ProjektGuMitarbeiter(){
		
	}
	
	/**
	 * @param idProjekt
	 * @param idSuMItarbeiter
	 * @param startDatum
	 * @param endDatum
	 * 
	 */
	
	public ProjektGuMitarbeiter(int idProjekt, int idGuMitarbeiter, GregorianCalendar startDatum, GregorianCalendar endDatum){
		super();
		this.idProjekt = idProjekt;
		this.idGuMitarbeiter = idGuMitarbeiter;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
	}

	/**
	 * @return the idProjekt
	 */
	public int getIdProjekt() {
		return idProjekt;
	}

	/**
	 * @param idProjekt the idProjekt to set
	 */
	public void setIdProjekt(int idProjekt) {
		this.idProjekt = idProjekt;
	}

	/**
	 * @return the idGuMitarbeiter
	 */
	public int getIdGuMitarbeiter() {
		return idGuMitarbeiter;
	}

	/**
	 * @param idGuMitarbeiter the idGuMitarbeiter to set
	 */
	public void setIdGuMitarbeiter(int idGuMitarbeiter) {
		this.idGuMitarbeiter = idGuMitarbeiter;
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
