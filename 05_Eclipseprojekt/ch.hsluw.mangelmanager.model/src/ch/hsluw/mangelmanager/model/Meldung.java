package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Meldung implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2067831453127875781L;

	@Id
	@GeneratedValue
	private Integer id;
	@OneToMany(cascade = CascadeType.PERSIST)
	private Mangel fkMangel;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Meldungstyp fkMeldungstyp;

	private String text;
	private boolean quittiert;
	private Login fkLogin;

	public Meldung() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mangel getFkMangel() {
		return fkMangel;
	}

	public void setFkMangel(Mangel fkMangel) {
		this.fkMangel = fkMangel;
	}

	public Meldungstyp getFkMeldungstyp() {
		return fkMeldungstyp;
	}

	public void setFkMeldungstyp(Meldungstyp fkMeldungstyp) {
		this.fkMeldungstyp = fkMeldungstyp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isQuittiert() {
		return quittiert;
	}

	public void setQuittiert(boolean quittiert) {
		this.quittiert = quittiert;
	}

	public Login getFkLogin() {
		return fkLogin;
	}

	public void setFkLogin(Login fkLogin) {
		this.fkLogin = fkLogin;
	}

}
