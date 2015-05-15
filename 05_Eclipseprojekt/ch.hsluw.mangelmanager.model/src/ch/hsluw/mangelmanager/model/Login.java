/*
 * ZWECK: Mangelmanager
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Diese Klasse dient als Login.
 * 
 * @version 1.0
 * @author miten
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Login.findByName", query = "SELECT l FROM Login l WHERE l.benutzername=:loginName")})

public class Login implements Serializable {

	private static final long serialVersionUID = 6294667886934890151L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String benutzername;
	private String passwort;
	private String email;
	@ManyToOne
	private Rolle fkrolle;

	public Login() {

	}
	
	/**
	 * @param benutzername
	 * @param passwort
	 * @param email
	 * @param fkrolle
	 */
	public Login(String benutzername, String passwort, String email,
			Rolle fkrolle) {
		super();
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.email = email;
		this.fkrolle = fkrolle;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the benutzername
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * @param benutzername the benutzername to set
	 */
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	/**
	 * @return the passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort the passwort to set
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fkrolle
	 */
	public Rolle getFkrolle() {
		return fkrolle;
	}

	/**
	 * @param fkrolle the fkrolle to set
	 */
	public void setFkrolle(Rolle fkrolle) {
		this.fkrolle = fkrolle;
	}
	
}
