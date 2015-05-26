package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String lyric;
	
	@OneToOne
	private Genre genre;
	
	@OneToOne
	private Album album;
	
	@OneToOne
	private Author author;
		
	public Track() {
		super();
	}

	public Track(Long id, String name, String lyric) {
		super();
		this.id = id;
		this.name = name;
		this.lyric = lyric;
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

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Brano [id=" + id + ", nome=" + name + ", testo=" + lyric
				+ ", genere=" + genre + ", album=" + album + ", autore="
				+ author + "]";
	}
		
}
