package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

public class TrackFacade {
	
    private EntityManager em;
    private EntityManagerFactory emf;

	public TrackFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}
	
	public Track createTrack(String name, String lyric, Author author, Album album, Genre genre) {
		Track track = new Track(name, lyric, genre, album, author);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(track);	
		tx.commit();
		em.close();
		emf.close();
		return track;
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

	public boolean deleteTrack(Long id) {
		Track track = em.find(Track.class, id);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(track);
			tx.commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}

	public boolean updateTrack(Long id, String name, String lyric, Author author, Album album, Genre genre, HttpServletRequest request) {
		Track track = new Track(id,name, lyric, genre, album, author);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(track);	
		tx.commit();
		em.close();
		emf.close();
		return true;
		/*Track track = em.find(Track.class, id);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			track.setName(name);
			track.setLyric(lyric);
			track.setAlbum(album);
			if(!track.getAuthor().getName().equals(author.getName())) {
				track.setAuthor(author); }
			track.setGenre(genre);
			tx.commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			request.setAttribute("errUpdate", e);
			return false;
		}
		return true;*/
	}
}
