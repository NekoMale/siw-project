package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserFacade {
	
    private EntityManager em;
    private EntityManagerFactory emf;

	public UserFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}
	
	public Utente register(String username, String email, String password) {
		Utente user = new Utente(username, password, email);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
		emf.close();
		return user;
	}
	
	public Utente findUser(String username) {
		Utente user;
		try {
			user = (Utente) em.createQuery("SELECT u FROM Utente u WHERE u.username LIKE :username").setParameter("username", username)
					.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return user;
	}
}