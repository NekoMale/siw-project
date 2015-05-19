package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Date dataDebutto;
	
	@Column(nullable=false)
	private String info;
	
	@OneToMany(mappedBy="autore")
	private List<Brano> brani;
	
	@OneToMany(mappedBy="autore")
	private List<Album> album;

	public Autore() {
		super();
	}

	public Autore(Long id, String nome, Date dataDebutto, String info) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDebutto = dataDebutto;
		this.info = info;
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

	public Date getDataDebutto() {
		return dataDebutto;
	}

	public void setDataDebutto(Date dataDebutto) {
		this.dataDebutto = dataDebutto;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Brano> getBrani() {
		return brani;
	}

	public void setBrani(List<Brano> brani) {
		this.brani = brani;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", dataDebutto="
				+ dataDebutto + ", info=" + info + ", brani=" + brani
				+ ", album=" + album + "]";
	}
	
	
	
}
