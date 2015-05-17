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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
	@NamedQuery(name = "ProjektGuMitarbeiter.findAllBauleiterByProjekt", query = "SELECT p FROM ProjektGuMitarbeiter p WHERE p.fkProjekt =:projektId")})
public class ProjektGuMitarbeiter implements Serializable {

	private static final long serialVersionUID = 5806477597388591398L;

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Projekt fkProjekt;
	@ManyToOne
	private GuMitarbeiter fkMitarbeiter;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar startDatum;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar endDatum;
	

	public ProjektGuMitarbeiter() {

	}

	/**
	 * @param fkProjekt
	 * @param fkuMItarbeiter
	 * @param startDatum
	 * @param endDatum
	 * 
	 */

	public ProjektGuMitarbeiter(Projekt fkProjekt,GuMitarbeiter fkMitarbeiter, GregorianCalendar startDatum,
			GregorianCalendar endDatum) {
		super();
		this.fkProjekt = fkProjekt;
		this.fkMitarbeiter = fkMitarbeiter;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fkProjekt
	 */
	public Projekt getFkProjekt() {
		return fkProjekt;
	}

	/**
	 * @param fkProjekt the fkProjekt to set
	 */
	public void setFkProjekt(Projekt fkProjekt) {
		this.fkProjekt = fkProjekt;
	}

	/**
	 * @return the fkMitarbeiter
	 */
	public GuMitarbeiter getFkMitarbeiter() {
		return fkMitarbeiter;
	}

	/**
	 * @param fkMitarbeiter the fkMitarbeiter to set
	 */
	public void setFkMitarbeiter(GuMitarbeiter fkMitarbeiter) {
		this.fkMitarbeiter = fkMitarbeiter;
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
