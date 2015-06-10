package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transaction;

public class FavouritesFacade {
    private EntityManager em;
    private EntityManagerFactory emf;

	public FavouritesFacade()  {
		emf = Persistence.createEntityManagerFactory("lyrics-unit");
		em = emf.createEntityManager();
	}
	

	public Favourites createFav(Track track, Users user) {
		Favourites fav = new Favourites(user, track);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(fav);
		tx.commit();
		em.close();
		emf.close();
		return fav;
	}


	public Favourites findFav(Users user, Track track) {
		Favourites fav;
		try {
			fav = (Favourites)
				  em.createQuery("SELECT f FROM Favourites f WHERE f.user.username LIKE :username AND f.track.name LIKE :trackName AND f.track.author.name LIKE :authorName")
					.setParameter("username", user.getUsername()).setParameter("trackName", track.getName()).setParameter("authorName", track.getAuthor().getName())
					.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		return fav;
	}


	public Favourites deleteFav(Track track, Users user) {
		Favourites fav = findFav(user,track);
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(fav);
			tx.commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			return fav;
		}
		return null;
	}
}
