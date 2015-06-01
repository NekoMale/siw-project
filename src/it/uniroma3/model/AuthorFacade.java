package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

public class AuthorFacade {
	
    private EntityManager em;
    private EntityManagerFactory emf;

	public AuthorFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}
	
	public Author getAuthor(String name) {
		Author author;
		try {
			author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name").setParameter("name", name)
						.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return author;
	}
}
