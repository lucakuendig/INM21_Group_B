/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Diese Klasse bildet eine Meldung ab.
 * 
 * @version 1.0
 * @author cdemir
 *
 */

@Entity
public class Meldung implements Serializable {

	private static final long serialVersionUID = 2067831453127875781L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Mangel fkMangel;

	@Temporal(TemporalType.DATE)
	private GregorianCalendar zeitpunkt;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Meldungstyp fkMeldungstyp;
	private String text;
	private boolean quittiert;
	private Login fkLogin;

	public Meldung() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fkMangel
	 * @param zeitpunkt
	 * @param fkMeldungstyp
	 * @param text
	 * @param quittiert
	 * @param fkLogin
	 */
	public Meldung(Mangel fkMangel, GregorianCalendar zeitpunkt,
			Meldungstyp fkMeldungstyp, String text, boolean quittiert,
			Login fkLogin) {
		super();
		this.fkMangel = fkMangel;
		this.zeitpunkt = zeitpunkt;
		this.fkMeldungstyp = fkMeldungstyp;
		this.text = text;
		this.quittiert = quittiert;
		this.fkLogin = fkLogin;
	}

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
	 * @return the fkMangel
	 */
	public Mangel getFkMangel() {
		return fkMangel;
	}

	/**
	 * @param fkMangel
	 *            the fkMangel to set
	 */
	public void setFkMangel(Mangel fkMangel) {
		this.fkMangel = fkMangel;
	}

	/**
	 * @return the fkMeldungstyp
	 */
	public Meldungstyp getFkMeldungstyp() {
		return fkMeldungstyp;
	}

	/**
	 * @param fkMeldungstyp
	 *            the fkMeldungstyp to set
	 */
	public void setFkMeldungstyp(Meldungstyp fkMeldungstyp) {
		this.fkMeldungstyp = fkMeldungstyp;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the quittiert
	 */
	public boolean getQuittiert() {
		return quittiert;
	}

	/**
	 * @param quittiert
	 *            the quittiert to set
	 */
	public void setQuittiert(boolean quittiert) {
		this.quittiert = quittiert;
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

}