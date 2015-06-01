package it.uniroma3.model;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

public class AlbumFacade {
    private EntityManager em;
    private EntityManagerFactory emf;

	public AlbumFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}

	public Album getAlbumByAuthor(String title, Long id) {
		Album album;
		
		try {
			album = (Album) em.createQuery("SELECT a FROM Album a WHERE a.title LIKE :title").setParameter("title", title).getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return album;
	}
	
}
