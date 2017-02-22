package fr.pizzeria.model;

public class Pizza {
	public int id = 0;
	public String code = "NUL";
	public String nom = "NoName";
	public double prix = 0.00;
	public static int nbPizzas = 0;
	
	public Pizza(){		
	}
	
	public Pizza(int id, String code, String nom, double prix){
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizzas++;
	}
}
