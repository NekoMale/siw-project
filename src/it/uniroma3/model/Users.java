package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private boolean isAdmin;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Favourites> favs;
	
	public Users() {
		this.favs = new LinkedList<Favourites>();
	}

	public Users(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = false;
		this.favs = new LinkedList<Favourites>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Favourites> getFavs() {
		return favs;
	}

	public void setFavs(List<Favourites> favs) {
		this.favs = favs;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", isAdmin=" + isAdmin + "]";
	}	
}
