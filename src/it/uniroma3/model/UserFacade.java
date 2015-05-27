package it.uniroma3.model;

import java.util.*;

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
	
	public Users register(String username, String email, String password) {
		Users user = new Users(username, password, email);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
		emf.close();
		return user;
	}
	
	public Users findUser(String username) {
		Users user;
		try {
			user = (Users) em.createQuery("SELECT u FROM Users u WHERE u.username LIKE :username").setParameter("username", username)
					.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return user;
	}
	
	public List<Users> retrieveAllUsers() {
		List<Users> users;
		try {
			users = em.createQuery("SELECT u FROM Users u").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return users;
	}
	
	public boolean promoteUser(Long id) {
		Users user = em.find(Users.class, id);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			user.setisAdmin(true);
			tx.commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteUser(Long id) {
		Users user = em.find(Users.class, id);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(user);
			tx.commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}