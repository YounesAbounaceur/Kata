package metier;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import entities.Compte;

public class BanqueTest {
	/*
	@Mock 
	private Banque banque;
	
    @Mock
    EntityManagerFactory emf;

    @Mock
    private EntityManager em;

    @Mock
    private EntityTransaction et;
    */
    private Banque banque;
    private EntityManager em;
	@Before 
	public void setUp() {
		banque = new Banque();
	    //em = mock(EntityManager.class);
		//MockitoAnnotations.initMocks(this);
		//emf = banque.getEntityManagerFactory();
		//banque.setEm(em);
		//banque = mock(Banque.class);
		
	}

	@Test
	//@Order(1)  
	public void creerCompteTest() {
		
		Compte cpt = new Compte(398);

		banque.creerCompte(cpt);
		
		Compte nvCompte = banque.getCompte(78);
		assertEquals(398, nvCompte.getSolde(),0);
		return;
	}
	
	@Test 
	public void verserTest() {
		banque.verser(68, 100);
		Compte nvCompte = banque.getCompte(68);
		assertEquals(310, nvCompte.getSolde(),0);
		assertEquals(2, nvCompte.getOperations().size(),0);
		return;
	}
	
	@Test	
	public void retirerTest() {
		banque.retirer(33, 2);
		Compte nvCompte = banque.getCompte(33);
		assertEquals(10, nvCompte.getSolde(),0);
		assertEquals(2, nvCompte.getOperations().size(),0);
		return;
	}
	
	@Test	
	public void virementTest() {
		banque.virement(23, 28, 100);
		Compte nvCompte1 = banque.getCompte(23);
		Compte nvCompte2 = banque.getCompte(28);
		assertEquals(612, nvCompte1.getSolde(),0);
		assertEquals(312, nvCompte2.getSolde(),0);
		
	}

}
