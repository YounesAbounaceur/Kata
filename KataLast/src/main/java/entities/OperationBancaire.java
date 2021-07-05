package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Operation
 *
 */
@Entity

public class OperationBancaire implements Serializable {

	
	  
	@Id @GeneratedValue
	private int idOperation;
	private Date dateOperation;
	private float somme; 
	private String typeOperation;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	Compte operant;
	

	public Compte getOperant() {
		return operant;
	}
	
	public void setOperant(Compte operant) {
		this.operant = operant;
	}
	public OperationBancaire() {
		super();
	}   
	public OperationBancaire(String typeOperation, float montant) {
		this.typeOperation = typeOperation;
		this.somme = montant;
		this.dateOperation = new Date();
		
	}
	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public float getSomme() {
		return this.somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}   
	public int getIdOperation() {
		return this.idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}   
	public Date getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
   
}
