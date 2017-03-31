package fr.pizzeria.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "numero", nullable = false, unique = true)
	private int numero;

	@Column(name = "statut", nullable = false)
	private Statut statut;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	// @ManyToMany
	// @JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name =
	// "commande_id", referencedColumnName = "id"), inverseJoinColumns =
	// @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	// @Transient
	// private Set<Pizza> pizzas;

	public Commande() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// public Set<Pizza> getPizzas() {
	// return pizzas;
	// }
	//
	// public void setPizzas(Set<Pizza> pizzas) {
	// this.pizzas = pizzas;
	// }

}
