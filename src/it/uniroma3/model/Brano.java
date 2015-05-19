package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Brano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String testo;
	
	@OneToOne
	private Genere genere;
	
	@OneToOne
	private Album album;
	
	@OneToOne
	private Autore autore;
		
	public Brano() {
		super();
	}

	public Brano(Long id, String nome, String testo) {
		super();
		this.id = id;
		this.nome = nome;
		this.testo = testo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Brano [id=" + id + ", nome=" + nome + ", testo=" + testo
				+ ", genere=" + genere + ", album=" + album + ", autore="
				+ autore + "]";
	}
		
}
