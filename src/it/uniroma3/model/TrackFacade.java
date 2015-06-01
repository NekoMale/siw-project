package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TrackFacade {
	
    private EntityManager em;
    private EntityManagerFactory emf;

	public TrackFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}
	
	public Track createTrack(String name, String lyric, Author author, Album album, Genre genre){
		Track t = new Track(name, lyric, genre, album, author);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(t);	
		tx.commit();
		em.close();
		emf.close();
		return t;
	}
	
	public Track findTrack(Long id) {
		Track track;
		try {
			track = em.find(Track.class, id);
		}
		catch(Exception e) {
			return null;
		}
		return track;
	}
	
	public List<Track> retrieveAllTracks() {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return tracks;
	}
}
