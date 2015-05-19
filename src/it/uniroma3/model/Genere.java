package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Genere {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="genere")
	private List<Brano> brani;

	public Genere() {
		super();
		this.brani = new LinkedList<Brano>();
	}

	public Genere(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.brani = new LinkedList<Brano>();
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

	public List<Brano> getBrani() {
		return brani;
	}

	public void setBrani(List<Brano> brani) {
		this.brani = brani;
	}

	@Override
	public String toString() {
		return "Genere [id=" + id + ", nome=" + nome + ", brani=" + brani + "]";
	}
	
	
}
