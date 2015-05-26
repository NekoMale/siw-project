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
	
	@OneToMany(mappedBy="track")
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

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((preferenze == null) ? 0 : preferenze.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (preferenze == null) {
			if (other.preferenze != null)
				return false;
		} else if (!preferenze.equals(other.preferenze))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", isAdmin=" + isAdmin + "]";
	}*/
	
	
}
