package fr.pizzeria.model;

public class Pizza implements Comparable<Pizza> {
	private String code = "NUL";
	private String nom = "NoName";
	private double prix = 0.00;
	private CategoriePizza categorie;

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza category) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = category;
	}

	public String toString() {
		return code + " -> " + nom + " (" + prix + " €) : " + categorie.getLibelle();
	}

	public int compareTo(Pizza pizza) {
		return this.code.compareTo(pizza.getCode());
	}
}
