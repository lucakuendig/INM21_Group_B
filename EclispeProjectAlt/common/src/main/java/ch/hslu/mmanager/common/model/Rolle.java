package ch.hslu.mmanager.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rolle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4845172977431179772L;
	
	@Id
	@GeneratedValue
	private int id;
	private String bezeichnung;
	
	public Rolle() {
		// TODO Auto-generated constructor stub
	}
	public Rolle(String bezeichnung){
		this.bezeichnung = bezeichnung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	

}
