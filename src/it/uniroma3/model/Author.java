package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private int debut;
	
	@Column(length=1000)
	private String info;
	
	@OneToMany(mappedBy="author")
	private List<Track> tracks;
	
	@OneToMany(mappedBy="author",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Album> album;

	public Author() {
		super();
	}

	public Author(String name) {
		super();
		this.name = name;
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

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + name + ", dataDebutto="
				+ debut + ", info=" + info + ", brani=" + tracks
				+ ", album=" + album + "]";
	}
	
	
	
}
