package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AlbumFacade {
    private EntityManager em;
    private EntityManagerFactory emf;

	public AlbumFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}

	public Album findAlbum(Long id) {
		Album album;
		try {
			album = em.find(Album.class, id);
		}
		catch(Exception e) {
			return null;
		}
		return album;
	}
	
	public Album getAlbumByAuthor(String title, String name) {
		Album album;
		
		try {
			album = (Album) em.createQuery("SELECT a FROM Album a WHERE a.title LIKE :title AND a.author.name LIKE :name")
								.setParameter("title", title).setParameter("name",name).getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return album;
	}

	public List<Album> retrieveAllAlbums() {
		List<Album> albums;
		try {
			albums = em.createQuery("SELECT a FROM Album a ORDER BY a.title ASC").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return albums;
	}

	public boolean updateAlbum(Long id, String title, int year, Author author) {
		try {
			Album album = new Album(title);
			album.setId(id);
			album.setAuthor(author);
			album.setYear(year);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(album);
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
