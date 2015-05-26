package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private int year;
	
	@Column(nullable=false)
	private int numberTracks;
	
	@ManyToOne
	private Author author;
	
	@OneToMany(mappedBy="album")
	private List<Track> tracks;

	public Album() {
		super();
	}

	public Album(Long id, String name, int year, int numberTracks) {
		super();
		this.id = id;
		this.title = name;
		this.year = year;
		this.numberTracks = numberTracks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public int getAnno() {
		return year;
	}

	public void setAnno(int year) {
		this.year = year;
	}

	public int getNumberTracks() {
		return numberTracks;
	}

	public void setNumberTracks(int numberTracks) {
		this.numberTracks = numberTracks;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setBrani(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", nome=" + title + ", anno=" + year
				+ ", numeroTracce=" + numberTracks + ", autore=" + author
				+ ", brani=" + tracks + "]";
	}
	
	
}
