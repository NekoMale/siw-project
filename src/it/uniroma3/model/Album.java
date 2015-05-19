package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private int anno;
	
	@Column(nullable=false)
	private int numeroTracce;
	
	@ManyToOne
	private Autore autore;
	
	@OneToMany(mappedBy="album")
	private List<Brano> brani;

	public Album() {
		super();
	}

	public Album(Long id, String nome, int anno, int numeroTracce) {
		super();
		this.id = id;
		this.nome = nome;
		this.anno = anno;
		this.numeroTracce = numeroTracce;
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

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getNumeroTracce() {
		return numeroTracce;
	}

	public void setNumeroTracce(int numeroTracce) {
		this.numeroTracce = numeroTracce;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public List<Brano> getBrani() {
		return brani;
	}

	public void setBrani(List<Brano> brani) {
		this.brani = brani;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", nome=" + nome + ", anno=" + anno
				+ ", numeroTracce=" + numeroTracce + ", autore=" + autore
				+ ", brani=" + brani + "]";
	}
	
	
}
