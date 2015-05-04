/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Diese Klasse bildet ein Subunternehmen ab.
 * 
 * @version 1.0
 * @author lkuendig
 *
 */

@Entity
public class Subunternehmen implements Serializable {

	private static final long serialVersionUID = -2526718021212938075L;

	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Adresse fkAdresse;
	private String name;
	private String telefon;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy ="fkSubunternehmen", fetch = FetchType.EAGER)
	private List<SuMitarbeiter> fkSuMitarbeiter;

	public Subunternehmen() {

	}

	/**
	 * @param adresse
	 * @param name
	 * @param telefon
	 * 
	 */
	public Subunternehmen(Adresse fkAdresse, String name,
			String telefon) {
		super();
		this.fkAdresse = fkAdresse;
		this.name = name;
		this.telefon = telefon;
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
	 * @return the fkAdresse
	 */
	public Adresse getFkAdresse() {
		return fkAdresse;
	}

	/**
	 * @param fkAdresse
	 *            the fkAdresse to set
	 */
	public void setFkAdresse(Adresse fkAdresse) {
		this.fkAdresse = fkAdresse;
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
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * @param telefon
	 *            the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	/**
	 * @return the fkSuMitarbeiter
	 */
	public List<SuMitarbeiter> getFkSuMitarbeiter() {
		return fkSuMitarbeiter;
	}

	/**
	 * @param fkSuMitarbeiter the fkSuMitarbeiter to set
	 */
	public void setFkSuMitarbeiter(List<SuMitarbeiter> fkSuMitarbeiter) {
		this.fkSuMitarbeiter = fkSuMitarbeiter;
	}


}
