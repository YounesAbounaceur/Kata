package metier;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entities.Compte;
import entities.OperationBancaire;




public class Banque {
	@PersistenceContext(unitName = "kataApp")
	
	private static final String PERSISTENCE_UNIT_NAME = "KataLast";
	private static EntityManagerFactory factory; 	

	public static EntityManagerFactory getEntityManagerFactory() {
    	if(factory == null) {
    		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	}
    	return factory;
    }
	
    
	public void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
	
	

	public void creerCompte(Compte cp) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		if(cp==null) throw new RuntimeException("Compte null");
		em.persist(cp);
		
		em.getTransaction().commit();
		em.close();
		
	}

	public Compte getCompte(int code) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Compte cp = em.find(Compte.class, code);
		if(cp==null) throw new RuntimeException("Compte introuvable");
		
		em.getTransaction().commit();
		em.close();
		
		return cp;
	}
	
	
	public void ajouterOpèration(Compte cp, OperationBancaire op) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		List<OperationBancaire> opèrations = new ArrayList<OperationBancaire>();
		opèrations = cp.getOperations();
		opèrations.add(op);
		op.setOperant(cp);
		cp.setOperations(opèrations);
		em.merge(cp);
		em.merge(op);
		
		em.getTransaction().commit();
		em.close();

	}


	public void verser(int idCompte, float montant) {
		 EntityManager em = getEntityManagerFactory().createEntityManager();
		 em.getTransaction().begin();
		 
		 
		 String typeOperation = "verser";
		 OperationBancaire op = new OperationBancaire(typeOperation, montant);
		 Compte cp = getCompte(idCompte);
		 cp.setSolde(cp.getSolde()+montant);
		 ajouterOpèration(cp, op);
		 
		 em.getTransaction().commit();
		 em.close();
		
	}

	public void retirer(int idCompte, float montant) {
		 EntityManager em = getEntityManagerFactory().createEntityManager();
		 em.getTransaction().begin();
		
		
		 String typeOperation = "retirer";
		 Compte cp = getCompte(idCompte);
		 if(cp.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
		 cp.setSolde(cp.getSolde()-montant);
		 OperationBancaire op = new OperationBancaire(typeOperation, montant);
		 ajouterOpèration(cp, op);

		em.getTransaction().commit();
		em.close();
	}

	public void virement(int idCompte1, int idCompte2, float montant) {
		retirer(idCompte1,montant);
		verser(idCompte2,montant);
		
	}

	public void setEm(EntityManager emanager) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em = emanager;
		
		em.getTransaction().commit();
		em.close();
		
	}

	
	
	
}
