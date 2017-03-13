package fr.pizzeria.model;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "prenom", nullable = false)
	private String prenom;

	public Personne() {
	}

}
