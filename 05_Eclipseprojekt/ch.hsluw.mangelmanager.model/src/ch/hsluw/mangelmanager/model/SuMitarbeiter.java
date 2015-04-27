/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Diese Klasse bildet einen SuMitarbeiter ab.
 * 
 * @version 1.0
 * @author lkuendig
 *
 */

@Entity
public class SuMitarbeiter extends Person implements Serializable {

	private static final long serialVersionUID = 1751601309829678863L;

	@Id
	@GeneratedValue
	private Integer id;
	@OneToMany(cascade = CascadeType.PERSIST)
	private Subunternehmen fkSubunternehmen;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Login fkLogin;

	public SuMitarbeiter() {
		super();
	}

	/**
	 * @param nachname
	 * @param vorname
	 * @param telefon
	 * @param fkSubunternehmen
	 * @param fkLogin
	 * 
	 */

	public SuMitarbeiter(String nachname, String vorname,
			String telefon, Subunternehmen fkSubunternehmen, Login fkLogin) {
		super(nachname, vorname, telefon);
		this.fkSubunternehmen = fkSubunternehmen;
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
	 * @return the fkSubunternehmen
	 */
	public Subunternehmen getFkSubunternehmen() {
		return fkSubunternehmen;
	}

	/**
	 * @param fkSubunternehmen
	 *            the fkSubunternehmen to set
	 */
	public void setFkSubunternehmen(Subunternehmen fkSubunternehmen) {
		this.fkSubunternehmen = fkSubunternehmen;
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
