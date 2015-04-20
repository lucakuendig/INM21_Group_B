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
public class GuMitarbeiter extends Person implements Serializable {
	
	private static final long serialVersionUID = 26991397546816960L;
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Login fkLogin;
	
	public GuMitarbeiter(){
		super();
	}
	
	/**
	 * @param id
	 * @param nachname
	 * @param vorname
	 * @param telefon
	 * @param fkLogin
	 * 
	 */
	
	public GuMitarbeiter(Integer id, String nachname, String vorname, String telefon, Login fkLogin){
		super(nachname, vorname, telefon);
		this.id = id;
		this.fkLogin = fkLogin;
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
	 * @return the fkLogin
	 */
	public Login getFkLogin() {
		return fkLogin;
	}

	/**
	 * @param fkLogin the fkLogin to set
	 */
	public void setFkLogin(Login fkLogin) {
		this.fkLogin = fkLogin;
	}

	
}
