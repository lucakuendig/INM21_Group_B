package ch.hslu.mmanager.common.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 8143057261936223601L;
		@Id
		@GeneratedValue
	    private int id; 
	    private String name;
	    private String vorname;
	    private String telefon;
	    
	    @OneToOne
	    private User user;
	    
	    public Person() {
			// TODO Auto-generated constructor stub
		}
	    public Person(String name, String vorname, String telefon, User user){
	    	this.name = name;
	    	this.vorname = vorname;
	    	this.telefon = telefon;
	    	this.user = user;
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getVorname() {
			return vorname;
		}
		public void setVorname(String vorname) {
			this.vorname = vorname;
		}
		public String getTelefon() {
			return telefon;
		}
		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	    
}
