package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenreFacade {
    private EntityManager em;
    private EntityManagerFactory emf;

	public GenreFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}
	
	public Genre getGenre(String name) {
		Genre genre;
		try {
			genre = (Genre) em.createQuery("SELECT g FROM Genre g WHERE g.name LIKE :name").setParameter("name", name)
								.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return genre;
	}

}
