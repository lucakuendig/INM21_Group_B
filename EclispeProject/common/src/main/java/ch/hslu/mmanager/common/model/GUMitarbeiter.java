package ch.hslu.mmanager.common.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class GUMitarbeiter extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381776303347024099L;
	public GUMitarbeiter(){
		
	}
	public GUMitarbeiter(String name, String vorname, String telefon, User user) {
		super(name, vorname, telefon, user);
	}
}
