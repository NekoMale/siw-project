package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Favourites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Users user;
	
	@ManyToOne
	private Track track;

	public Favourites(Long id, Users user, Track track) {
		super();
		this.id = id;
		this.user = user;
		this.track = track;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	
	
}