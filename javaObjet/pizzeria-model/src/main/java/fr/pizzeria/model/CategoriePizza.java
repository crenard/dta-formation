package fr.pizzeria.model;

/**
 * Enumeration des categories de pizzas
 * 
 * @author ETY 10
 *
 */
public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), VEGETARIEN("Vegetarien");

	private String libelle;

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
