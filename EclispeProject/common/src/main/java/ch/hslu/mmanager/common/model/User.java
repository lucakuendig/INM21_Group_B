package ch.hslu.mmanager.common.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4463668969221410351L;
	@Id
	@GeneratedValue
	private int id;
	private String benutzername;
	private String passwort;
	private String email;
	@ManyToOne(cascade=CascadeType.ALL)
	private Rolle rolle;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String benutzername, String passwort, String email, Rolle rolle){
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.email = email;
		this.rolle = rolle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rolle getRolle() {
		return rolle;
	}

	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}
	
	
	
	
}
