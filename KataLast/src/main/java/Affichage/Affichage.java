package Affichage;

import javax.persistence.EntityManager;

import metier.Banque;
import entities.Compte;

public class Affichage {

	public static void main(String[] args) {
		
		
		Compte compte = new Compte(38);
		
		Banque banque = new Banque();

		banque.creerCompte(compte);

	}

}
