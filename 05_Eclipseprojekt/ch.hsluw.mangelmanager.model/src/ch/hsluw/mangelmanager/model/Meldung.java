package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Meldung implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2067831453127875781L;

	@Id
	@GeneratedValue
	private Integer id;

	private Integer fkMangel;
	private Integer fkMeldungsTyp;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private String text;
	
	private boolean quittiert;
	private Integer fkLogin;

	
	
	
	
	public Meldung() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkMangel() {
		return fkMangel;
	}

	public void setFkMangel(Integer fkMangel) {
		this.fkMangel = fkMangel;
	}

	public Integer getFkMeldungsTyp() {
		return fkMeldungsTyp;
	}

	public void setFkMeldungsTyp(Integer fkMeldungsTyp) {
		this.fkMeldungsTyp = fkMeldungsTyp;
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

	public Integer getFkLogin() {
		return fkLogin;
	}

	public void setFkLogin(Integer fkLogin) {
		this.fkLogin = fkLogin;
	}
	
	
}
