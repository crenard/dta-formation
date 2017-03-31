package fr.pizzeria.model;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
		@NamedQuery(name = "Client.find", query = "SELECT c FROM Client c WHERE email LIKE :email") })
@Table(name = "client")
public class Client extends Personne {

	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "password")
	private String password;

	public Client() {
	}

	public Client(String nom, String prenom, String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(23, 31).append(email).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return new EqualsBuilder().append(email, other.email).isEquals();
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
