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
	
	public Users findUser(Long id) {
		Users user;
		try {
			user = em.find(Users.class, id);
		}
		catch(Exception e) {
			return null;
		}
		return user;
	}
	
	public Users getUser(String username) {
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
	
	public Users findEmail(String email) {
		Users user;
		try {
			user = (Users) em.createQuery("SELECT u FROM Users u WHERE u.email LIKE :email").setParameter("email", email)
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

	public boolean downgradeUser(Long id) {
		Users user = em.find(Users.class, id);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			user.setisAdmin(false);
			tx.commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean upDataUser(Long id, String username, String email) {
		Users user = em.find(Users.class, id);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			user.setUsername(username);
			user.setEmail(email);
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

	public List<Users> retrieveUsersByAdvancedSearch(String username, String email) {
		List<Users> users;
		try {
			users = em.createQuery("SELECT u FROM Users u WHERE lower(u.username) LIKE :username AND lower(u.email) LIKE :email")
						.setParameter("username", "%"+username.toLowerCase()+"%")
						.setParameter("email", "%"+email.toLowerCase()+"%")
						.getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return users;
	}

	public Object getUserByEmail(String email) {
		Users user;
		try {
			user = (Users) em.createQuery("SELECT u FROM Users u WHERE u.email LIKE :email").setParameter("email", email)
					.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return user;
	}
}