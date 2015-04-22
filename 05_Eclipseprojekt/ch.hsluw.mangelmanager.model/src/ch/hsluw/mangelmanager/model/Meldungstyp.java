package ch.hsluw.mangelmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meldungstyp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6358290611507121648L;

	@Id
	@GeneratedValue
	private Integer id;
	private String bezeichnung;

	public Meldungstyp() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}
