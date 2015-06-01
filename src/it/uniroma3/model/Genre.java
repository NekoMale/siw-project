package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="genre")
	private List<Track> track;

	public Genre() {
		super();
		this.track = new LinkedList<Track>();
	}

	public Genre(String name) {
		super();
		this.name = name;
		this.track = new LinkedList<Track>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return track;
	}

	public void setTracks(List<Track> tracks) {
		this.track = tracks;
	}

	@Override
	public String toString() {
		return "Genere [id=" + id + ", nome=" + name + ", brani=" + track + "]";
	}
	
	
}
