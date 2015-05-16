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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;


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

//	@Id
//	@GeneratedValue
//	private Integer id;
	@ManyToOne
	private Subunternehmen fkSubunternehmen;
	@ManyToOne(cascade = CascadeType.ALL)
	private Login fkLogin;
	@OneToMany (mappedBy = "fkMitarbeiter", fetch = FetchType.EAGER)
	private List<ProjektSuMitarbeiter> fkProjektSuMitarbeiter;

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

//	/**
//	 * @return the id
//	 */
//	public Integer getId() {
//		return id;
//	}
//
//	/**
//	 * @param id
//	 *            the id to set
//	 */
//	public void setId(Integer id) {
//		this.id = id;
//	}

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

	/**
	 * @return the fkProjektSuMitarbeiter
	 */
	public List<ProjektSuMitarbeiter> getFkProjektSuMitarbeiter() {
		return fkProjektSuMitarbeiter;
	}

	/**
	 * @param fkProjektSuMitarbeiter the fkProjektSuMitarbeiter to set
	 */
	public void setFkProjektSuMitarbeiter(
			List<ProjektSuMitarbeiter> fkProjektSuMitarbeiter) {
		this.fkProjektSuMitarbeiter = fkProjektSuMitarbeiter;
	}
	
    public String toString() {
        return getNachname() + " " + getVorname();
    }


}
