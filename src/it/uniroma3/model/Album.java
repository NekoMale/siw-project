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
	
	@Column
	private int year;
	
	@Column
	private int numberTracks;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private Author author;
	
	@OneToMany(mappedBy="album")
	private List<Track> tracks;

	public Album() {
		super();
	}

	public Album(String name) {
		super();
		this.title = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
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
