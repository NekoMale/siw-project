package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Preferenza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Brano brano;

	public Preferenza(Long id, Utente utente, Brano brano) {
		super();
		this.id = id;
		this.utente = utente;
		this.brano = brano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Brano getBrano() {
		return brano;
	}

	public void setBrano(Brano brano) {
		this.brano = brano;
	}
	
	
}
