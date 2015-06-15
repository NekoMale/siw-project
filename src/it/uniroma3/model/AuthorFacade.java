package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AuthorFacade {
	
    private EntityManager em;
    private EntityManagerFactory emf;

	public AuthorFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}	


	public Author findAuthor(Long id) {
		Author author;
		try {
			author = em.find(Author.class, id);
		}
		catch(Exception e) {
			return null;
		}
		return author;
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
	
	public List<Author> retrieveAllAuthors(){
		List<Author> authors;
		try {
			authors = em.createQuery("SELECT a FROM Author a").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return authors;
	}
	
	public List<Author> retrieveAllAuthorsOrdered(){
		List<Author> authors;
		try {
			authors = em.createQuery("SELECT a FROM Author a ORDER BY a.name ASC").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return authors;
	}


	public boolean updateAuthor(Long id, String name, int debut, String info) {
		try {
			Author author = new Author(name);
			author.setId(id);
			author.setDebut(debut);
			author.setInfo(info);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(author);
			tx.commit();
			em.close();
			emf.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
