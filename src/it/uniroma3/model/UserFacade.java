package it.uniroma3.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserFacade {
	
	private Map<Long, Utente> users;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	public UserFacade() {
		this.users = new HashMap<Long, Utente>();
	}
	
	public Utente register(String username, String email, String password) {
		
		this.emf = Persistence.createEntityManagerFactory("lyrics-unit");
		this.em = emf.createEntityManager();		
		this.tx = em.getTransaction();
		Utente user = new Utente(username, password, email);
		this.users.put(new Long(users.size()), user);
		this.tx.begin();
		this.em.persist(user);
		this.tx.commit();
		this.em.close();
		this.emf.close();
		return user;
	}
	
	
	private void openEM() {
		this.emf = Persistence.createEntityManagerFactory("lyrics-unit");
		this.em = emf.createEntityManager();		
		this.tx = em.getTransaction();
	}
	private void closeEM() {
		this.em.close();
		this.emf.close();
	}

}
