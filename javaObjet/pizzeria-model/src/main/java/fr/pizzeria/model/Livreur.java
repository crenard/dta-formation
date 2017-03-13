package fr.pizzeria.model;

import javax.persistence.*;

@Entity
@Table(name = "livreur")
public class Livreur extends Personne implements GenericData {

	public Livreur() {
	}

}
