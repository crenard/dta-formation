package fr.pizzeria.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends Personne {

	@Column(name = "email")
	private String email;
	@Column(name = "password", nullable = false)
	private String password;

	public Client() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
