package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false,length=10000)
	private String lyric;
	
	@Column(nullable=false)
	private int favs;
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private Genre genre;
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private Album album;
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private Author author;
		
	public Track() {
	}

	public Track(String name, String lyric) {
		this.name = name;
		this.lyric = lyric;
		this.favs = 0;
	}

	public Track(String name, String lyric, Genre genre, Album album, Author author) {
		super();
		this.name = name;
		this.lyric = lyric;
		this.genre = genre;
		this.album = album;
		this.author = author;
		this.favs = 0;
	}

	public Track(Long id, String name, String lyric, Genre genre, Album album, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.lyric = lyric;
		this.genre = genre;
		this.album = album;
		this.author = author;
		this.favs = 0;
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
	
	public int getFavs() {
		return favs;
	}

	public void setFavs(int favs) {
		this.favs = favs;
	}

	@Override
	public String toString() {
		return "Brano [id=" + id + ", nome=" + name + ", testo=" + lyric
				+ ", genere=" + genre + ", album=" + album + ", autore="
				+ author + "]";
	}
		
}
