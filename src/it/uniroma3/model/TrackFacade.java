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
	
	public List<Track> retrieveAllTracksOrdered() {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t ORDER BY t.name ASC").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return tracks;
	}

	public List<Track> retrieveLastTracks() {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t ORDER BY t.id DESC").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return tracks;
	}

	public List<Track> retrieveLikedTracks() {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t ORDER BY t.favs DESC").getResultList();
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
	}

	public List<Track> retrieveTracksByKeyword(String keyword) {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t WHERE lower(t.name) LIKE :keyword OR lower(t.author.name) LIKE :keyword OR lower(t.album.title) LIKE :keyword OR lower(t.lyric) LIKE :keyword")
						.setParameter("keyword", "%"+keyword.toLowerCase()+"%").getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return tracks;
	}

	public List<Track> retrieveTracksByAdvancedSearch(String lyric, String nameTrack, String albumTitle, String nameAuthor) {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t WHERE lower(t.name) LIKE :nameTrack AND lower(t.author.name) LIKE :nameAuthor AND lower(t.album.title) LIKE :albumTitle AND lower(t.lyric) LIKE :lyric")
						.setParameter("nameTrack", "%"+nameTrack.toLowerCase()+"%")
						.setParameter("nameAuthor", "%"+nameAuthor.toLowerCase()+"%")
						.setParameter("albumTitle", "%"+albumTitle.toLowerCase()+"%")
						.setParameter("lyric", "%"+lyric.toLowerCase()+"%")
						.getResultList();
		}
		catch(Exception e) {
			return null;
		}
		return tracks;
	}
	
	public List<Track> retrieveTracksByGenreOrdered(String genreName) {
		List<Track> tracks;
		try {
			tracks = em.createQuery("SELECT t FROM Track t WHERE t.genre.name LIKE :genre ORDER BY t.genre.name ASC")
						.setParameter("genre",""+genreName)
						.getResultList();
		}
		catch(Exception e){
			return null;
		}
		return tracks;
	}
}
