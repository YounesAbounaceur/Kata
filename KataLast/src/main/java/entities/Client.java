package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
public class Client implements Serializable {

	   
	@Id @GeneratedValue
	private int idClient;
	private String email;
	private String nom;
	private Date dateNaissance;
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch=FetchType.EAGER)
	Compte sonCompte;
	

	public Compte getSonCompte() {
		return sonCompte;
	}
	public void setSonCompte(Compte sonCompte) {
		this.sonCompte = sonCompte;
	}
	public Client() {
		super();
	}   
	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
   
}
