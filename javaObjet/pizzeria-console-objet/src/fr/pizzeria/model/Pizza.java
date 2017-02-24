package fr.pizzeria.model;

public class Pizza {
	private String code = "NUL";
	private String nom = "NoName";
	private double prix = 0.00;
	public static int nbPizzas = 0;

	public Pizza() {
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public Pizza(String code, String nom, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizzas++;
	}
}
