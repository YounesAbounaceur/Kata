package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity

public class Compte implements Serializable {

	   
	@Id @GeneratedValue
	private int idCompte;
	private Date dateCreation;
	private float solde = (float) 0;
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch=FetchType.EAGER)
	Client owner;
	
	@OneToMany(mappedBy="operant",fetch=FetchType.EAGER)
	List<OperationBancaire> operations = new ArrayList<OperationBancaire>();
	
	public Compte(float solde) {
		this.solde = solde;
		dateCreation = new Date();
		
	}
	

	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner = owner;
	}
	public List<OperationBancaire> getOperations() {
		return operations;
	}
	public void setOperations(List<OperationBancaire> operations) {
		this.operations = operations;
	}
	public Compte() {
		super();
	}   
	public int getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}   
	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
   
}
