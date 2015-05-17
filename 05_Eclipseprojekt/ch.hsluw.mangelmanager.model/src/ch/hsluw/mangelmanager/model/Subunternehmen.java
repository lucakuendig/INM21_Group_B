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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Diese Klasse bildet ein Subunternehmen ab.
 * 
 * @version 1.0
 * @author lkuendig
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Subunternehmen.findBySubunternehmenMitarbeiter", query = "SELECT sm FROM SuMitarbeiter sm WHERE sm.fkSubunternehmen=:subunternehmenId"),
	@NamedQuery(name = "Subunternehmen.findAllSubunternehmenByProjekt", query = "SELECT DISTINCT sm.fkSubunternehmen FROM SuMitarbeiter sm, ProjektSuMitarbeiter ps WHERE ps.fkMitarbeiter = sm.id AND ps.fkProjekt =:projektId")})
public class Subunternehmen implements Serializable {

	private static final long serialVersionUID = -2526718021212938075L;

	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL)
	private Adresse fkAdresse;
	private String name;
	private String telefon;

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

//	/**
//	 * @return the fkSuMitarbeiter
//	 */
//	public List<SuMitarbeiter> getFkSuMitarbeiter() {
//		return fkSuMitarbeiter;
//	}
//
//	/**
//	 * @param fkSuMitarbeiter the fkSuMitarbeiter to set
//	 */
//	public void setFkSuMitarbeiter(List<SuMitarbeiter> fkSuMitarbeiter) {
//		this.fkSuMitarbeiter = fkSuMitarbeiter;
//	}
	
    public String toString() {
        return name;
    }


}
